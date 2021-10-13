package com.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSBase extends Base {

    public static IOSDriver DesiredCapabilities(String appName) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/Framework/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        File appDir = new File("/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources/");
        File app = new File(appDir, (String) prop.get(appName));
        String device = (String) prop.get("iosDevice");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.UDID, "111649F0-F13E-487A-8348-AA685C33679E");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        capabilities.setCapability("commandTimeouts", "12000");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        IOSDriver driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        return driver;
    }
}
