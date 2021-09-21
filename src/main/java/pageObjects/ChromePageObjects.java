package pageObjects;

import com.Framework.BrowserBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class ChromePageObjects extends BrowserBase {

    public static WebElement getHomeButton() {
        String xpath = "//icon[@class='nav-logo lazy-loaded']";
        waitForElement(driver.findElementByXPath(xpath), 10, 1);
        WebElement homeButton = driver.findElementByXPath(xpath);
        return homeButton;
    }

    public static String getWelcomeMessage() {
        String xpath = "//h1[@class='hero__headline hero__headline--basic hero__headline--non-blue']";
        waitForElement(driver.findElementByXPath(xpath), 10, 1);
        WebElement welcomeMessage = driver.findElementByXPath(xpath);
        String text = welcomeMessage.getText();
        return text;
    }
}
