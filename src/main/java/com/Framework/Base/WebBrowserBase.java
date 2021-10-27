package com.Framework.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowserBase {

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/madison.vincent/IdeaProjects/DemoFramework/src/main/resources/chromedriver web");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
