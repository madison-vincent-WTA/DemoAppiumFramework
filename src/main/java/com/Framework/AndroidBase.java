package com.Framework;

import java.io.File;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.IReporter;
import org.testng.Reporter;

public class AndroidBase implements IReporter { // TODO convert this class to general base or "common"
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement>  driver;
    public static AssertionLogging softAssert = new AssertionLogging();

    public AppiumDriverLocalService startServer() {
        boolean flag=	checkIfServerIsRunnning(4723);
        if(!flag)
        {
            service=AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/main/resources/startEmulator.bat");
        Thread.sleep(6000);
    }

    public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Framework/global.properties");
        Properties prop=new Properties();
        prop.load(fis);
        File appDir = new File("/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources/");
        File app = new File(appDir, (String) prop.get(appName));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String device=(String) prop.get("androiddevice");

        if(device.contains("emulator"))
        {
            startEmulator();
            // This is specifically asking if the name of the device contains the word "Emulator"
            // so it will open the emulator on its own before the test
            // TODO add this to a beforetest?
        }

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<>(new URL("http://192.168.50.58:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void getScreenshot(String testName) throws IOException {
        File scrFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File (System.getProperty("user.dir")+"/test-output/Screenshots/"+testName+".png"));
        File destFile = new File(System.getProperty("user.dir")+"/test-output/Screenshots/"+testName+".png");
        FileUtils.copyFile(scrFile, destFile);
        Reporter.log("<a href='/DemoFramework/test-output/Screenshots/"+testName+".png'> <img src='/DemoFramework/test-output/Screenshots/"+testName+".png' height='400' width='200'/> </a>");
        System.out.println("***** Screenshot Captured *****");

        //Need the link to be http://localhost:63342/DemoFramework/test-output/Screenshots/checkButtonFunction.png
        // is currently http://localhost:63342/Users/madison.vincent/IdeaProjects/DemoFramework/test-output/Screenshots/checkButtonFunction.png

// TODO - images are broken in emailable report and unsure why.
//  The screenshot is captured and the path in the image link seems correct, but returns a 404 error
        //  Additionally, never figured out images in Extent Reports.
    }

    public static WebElement waitForElement(WebElement element, int timoutSec, int pollingSec) {

        FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timoutSec, TimeUnit.SECONDS)
                .pollingEvery(pollingSec, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);

        for (int i = 0; i < 2; i++) {
            try {
                fWait.until(ExpectedConditions.visibilityOf(element));
                fWait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e) {

                System.out.println("Element Not found trying again - " + element.toString().substring(70));
                e.printStackTrace();
            }
        }
        return element;
    }
}

