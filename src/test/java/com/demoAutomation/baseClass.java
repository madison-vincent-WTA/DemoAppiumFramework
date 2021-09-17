package com.demoAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class baseClass {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        // Connecting to the emulator device in Android Studio (via AVD Manager)
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 30");

        // Identifying the .apk file we are using for our app, contained within the project
        File appDirectory = new File("/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources");
        File app = new File(appDirectory, "ApiDemos-debug (1).apk");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        // Connecting to UIAutomator from Android Studio
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        // Adding Chrome Driver Capabilities
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://192.168.50.58:4723/wd/hub"), cap);
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        return driver;
    }

}

