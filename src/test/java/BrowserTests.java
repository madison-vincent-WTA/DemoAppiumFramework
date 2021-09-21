import com.Framework.BrowserBase;
import com.Framework.AllTestData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrowserTests extends BrowserBase {

    @Test (dataProvider= "BrowserTestData",dataProviderClass= AllTestData.class)
    public void testName(String expected) throws IOException, InterruptedException {
        WebDriver driver = capabilities("chrome");
       driver.get("https://linkedin.com");
       chrome.getHomeButton().click();

        softAssert.assertEquals(chrome.getWelcomeMessage(), expected, "Checking the welcome message");

        softAssert.assertAll();
    }
}
