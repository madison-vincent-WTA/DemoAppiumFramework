import com.Framework.BrowserBase;
import com.Framework.AllTestData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrowserTests extends BrowserBase {

    @Test (dataProvider= "BrowserTestData",dataProviderClass= AllTestData.class)
    public void checkWelcomeMessage(String expected) throws IOException, InterruptedException {
        WebDriver driver = capabilities();
       driver.get("https://linkedin.com");
       Thread.sleep(3000);
       chrome.getHomeButton().click();
        Thread.sleep(3000);
        softAssert.assertEquals(chrome.getWelcomeMessage(), expected, "Checking the welcome message");

        softAssert.assertAll();
    }
}
