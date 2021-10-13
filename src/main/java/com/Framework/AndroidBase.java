package com.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidBase extends Base {

    public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Framework/global.properties");
        Properties prop=new Properties();
        prop.load(fis);
        File appDir = new File("/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources/");
        File app = new File(appDir, (String) prop.get(appName));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String device=(String) prop.get("androidDevice");

        if(device.contains("emulator"))
        {
            startEmulator();
            // This is specifically asking if the name of the device contains the word "Emulator"
            // so it will open the emulator on its own before the test
            // TODO add this to a beforetest?
            //TODO update device names for physical / emulator and comment accordingly
        }

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<>(new URL("http://192.168.50.58:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}

