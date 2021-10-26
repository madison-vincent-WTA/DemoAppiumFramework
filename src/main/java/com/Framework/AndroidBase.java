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

    //This is where we set up Appium to run tests. Driver, Automation Environment, Device, App, etc.

    public static  AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException {
        // Creates a FileInputStream by opening a connection to an actual file, the file named by the path name in the file system
        //This defines where our Global Properties live, which we will reference in the code that follows
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Framework/global.properties");
        // Creates an empty property list with no default values.
        Properties prop=new Properties();
        //Reads a property list (key and element pairs) from the input stream.
        prop.load(fis);
        //Retrieving the pathname for the folder containing the app file and storing it as a property
        String directory=(String) prop.get("appDir");
        //Supplying the pathname for the app file as stored previously
        File appDir = new File(directory);
        //Retrieving the App Name from Global Properties and storing it as a property
        File app = new File(appDir, (String) prop.get("androidApp"));
        // Retrieving the device name from Global Properties and storing it as a property
        String device=(String) prop.get("androidDevice");

        // Initializing Desired Capabilities, which is what we utilize to set properties for our testing.
        //Setting all the properties below
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Telling Appium which device to use based on the property we set earlier
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        //Telling Appium that we are using the Android Studio UI Automator to run test automation on the app
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        //Telling Appium where to find the application for testing
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        //This defines how long Appium should wait for a new command from the client before assuming the client ended the session
        //Set to 0 to disable the timeout, but this isn't recommended as it allows automation sessions to continue indefinitely
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30);

        //Setting up the driver
        String address=(String) prop.get("IP");
        driver = new AndroidDriver<>(new URL(address), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}

