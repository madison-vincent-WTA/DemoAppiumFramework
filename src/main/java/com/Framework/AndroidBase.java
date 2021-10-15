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

    public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
        // Creates a FileInputStream by opening a connection to an actual file, the file named by the path name in the file system
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Framework/global.properties");
        // Creates an empty property list with no default values.
        Properties prop=new Properties();
        //Reads a property list (key and element pairs) from the input stream.
        prop.load(fis);
        //Defining the folder directory that the app file is currently in
        File appDir = new File("/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources/");
        //Retrieving the App Name from Global Properties and storing it as a property
        File app = new File(appDir, (String) prop.get(appName));
        // Retrieving the device name from Global Properties and storing it as a property
        String device=(String) prop.get("androidDevice");
        //TODO investigate whether we can get the app name this way as well

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
        //TODO testing on pre-installed apps and physical devices, How easy is it to open a pre-installed app rather than one hosted here

        //Setting up the driver
        driver = new AndroidDriver<>(new URL("http://192.168.50.58:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}

