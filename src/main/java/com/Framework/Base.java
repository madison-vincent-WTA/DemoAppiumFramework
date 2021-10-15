package com.Framework;

import com.Framework.Listeners.AssertionLogging;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;
    public static AssertionLogging softAssert = new AssertionLogging();

    public static boolean checkIfServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        //Checking to see if the Appium server is running and returning a true or false value
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

    public AppiumDriverLocalService startServer() {
        //Checking if the Appium server is running and starting it if it is not
        boolean flag=	checkIfServerIsRunning(4723);
        if(!flag)
        {
            service=AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public AppiumDriverLocalService stopServer() {
        //Checking if the Appium server is running and stopping it if it is
        boolean flag=	checkIfServerIsRunning(4723);
        if(flag)
        {
            service=AppiumDriverLocalService.buildDefaultService();
            service.stop();
        }
        return service;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        //Starting the emulator
        //Defining the path and file that will be used to start the emulator via the Terminal
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/main/resources/startEmulator.bat");
        //TODO Update startEmulator.bat to use Global Properties
        //Forcing a 6 second wait to allow the emulator to load
        Thread.sleep(6000);
    }

//    if (device.contains("emulator"))
//    {
//        startEmulator();
//        // IF the device name in Global Properties contains the word "emulator", we will start the emulator
//        //This requires you to change the naming convention in Android Virtual Devices
//        //TODO add this to a BeforeTest?
//        //TODO add to a separate method
//        //TODO update device names for physical / emulator and comment accordingly
//        //TODO add If/Then logic or an AfterTest that shuts down the emulator
//    }

    public static void getScreenshot(String testName) throws IOException {
        //Capturing a screenshot and saving it in the test-output/Screenshots folder in the project. It is also logged to the Emailable-Report in test-output
        //Take a screenshot and save it as a file
        File scrFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Copy the screenshot and save it as a file in the project directory
        FileUtils.copyFile(scrFile,new File (System.getProperty("user.dir")+"/test-output/Screenshots/"+testName+".png"));

        // Creates a FileInputStream by opening a connection to an actual file, the file named by the path name in the file system
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Framework/global.properties");
        // Creates an empty property list with no default values.
        Properties prop=new Properties();
        //Reads a property list (key and element pairs) from the input stream.
        prop.load(fis);
        //Retrieving the project name from Global Properties and storing it as a string
        String project=(String) prop.get("projectName");

        //Adding the screenshot to emailable-report.html in test-output folder.
        //Project string is used to define the image location as a 404 error is returned without this
        Reporter.log("<a href='/"+project+"/test-output/Screenshots/"+testName+".png'> <img src='/"+project+"/test-output/Screenshots/"+testName+".png' height='400' width='200'/> </a>");

        //Logging that a screenshot was captured in test output
        System.out.println("***** Screenshot Captured *****");
        //TODO - see if its possible to add this to Extent Reports as well...
    }

    public static WebElement waitForElement(WebElement element, int timeOutSec, int pollingSec) {
        //Waiting for an element to appear with a defined timeout and polling time
        //Setting up the FluentWait
        FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutSec))
                .pollingEvery(Duration.ofMillis(pollingSec));
        //Waiting for the element to be visible and interactable
        for (int i = 0; i < 2; i++) {
            try {
                fWait.until(ExpectedConditions.visibilityOf(element));
                fWait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e) {
                //Logging information for errors
                System.out.println("Element Not found trying again - " + element.toString().substring(70));
                e.printStackTrace();
            }
        }
        //Returning the element for use in other methods
        return element;
    }
}
