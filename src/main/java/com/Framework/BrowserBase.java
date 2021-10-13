package com.Framework;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.ChromePageObjects;
import java.io.IOException;
import java.net.URL;

public class BrowserBase extends Base {

    public static RemoteWebDriver driver;
    public static AssertionLogging softAssert = new AssertionLogging();
    public static ChromePageObjects chrome = new ChromePageObjects();

    public static WebDriver capabilities() throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 30");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        //TODO - Create Global Property for Driver Name and Executables
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("chromedriverExecutable","/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources/chromedriver");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");

        driver = new RemoteWebDriver(new URL("http://192.168.50.58:4723/wd/hub"), capabilities);

        return driver;
    }
}
