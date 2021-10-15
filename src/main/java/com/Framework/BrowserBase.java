package com.Framework;

import com.Framework.Listeners.AssertionLogging;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.Browser.LandingPageObjects;
import java.io.IOException;
import java.net.URL;

public class BrowserBase extends Base {

    public static RemoteWebDriver driver;
    public static AssertionLogging softAssert = new AssertionLogging();
    public static LandingPageObjects chrome = new LandingPageObjects();

    public static WebDriver capabilities() throws IOException {
        // Initializing Desired Capabilities, which is what we utilize to set properties for our testing.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Setting all the properties below
        //Telling Appium which device to use
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 30");
        //Telling Appium that we are using Android Studio UI Automator to access the browser and run test automation on the app
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        //Telling Appium which browser we are using for testing
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        //Providing the capability name we are setting (Chrome Driver Executable ) as well as the file path to the chrome driver
        capabilities.setCapability("chromedriverExecutable","/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources/chromedriver");
        // Providing platform name and version (Maybe not needed?)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        //TODO - Create Global Property for all of the above capabilities, organize global properties in a way that makes sense
        //TODO test if having Platform and Version Name is needed here.. It was added during debugging and not sure it made a difference
        //TODO Creating a framework to ensure this works on iOS as well
        //TODO - Using other browsers??

        //Setting up the driver
        driver = new RemoteWebDriver(new URL("http://192.168.50.58:4723/wd/hub"), capabilities);
        return driver;
    }
}
