package com.Framework.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebBrowserBase {

    public static WebDriver driver() throws IOException {
        // Creates a FileInputStream by opening a connection to an actual file, the file named by the path name in the file system
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/Framework/global.properties");
        // Creates an empty property list with no default values.
        Properties prop = new Properties();
        //Reads a property list (key and element pairs) from the input stream.
        prop.load(fis);
        String property = (String) prop.get("property");
        String driverDir = (String) prop.get("driverDir");
        System.setProperty(property, driverDir);

        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new SafariDriver();
//        WebDriver driver = new EdgeDriver();

//        if (property == "webdriver.chrome.driver") {
//            driver = new ChromeDriver();
//        } else if (property == "webdriver.gecko.driver") {
//                driver = new FirefoxDriver();
//            } else {
//                    driver = new SafariDriver();
//                }
        //TODO fix the above web driver logic... not working after adding if/else statements
        //TODO separate testng.xml for webdriver versus mobile
return driver;
    }
}
