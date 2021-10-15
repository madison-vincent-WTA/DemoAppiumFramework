import com.Framework.BrowserBase;
import com.Framework.DataProviders.Browser.LandingPageData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrowserTests extends BrowserBase {

    static WebDriver driver;

    static {
        try {
            driver = capabilities();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //TODO Figure out why calling driver in the method returns a null pointer and requires the driver to be initialized in the class

    @Test (dataProvider= "BrowserTestData",dataProviderClass= LandingPageData.class)
    public void checkWelcomeMessage(String expected) throws IOException, InterruptedException {

        // Telling the driver to navigate to a specific URL=
       driver.get("https://linkedin.com");
       //TODO: Context switching when the app supplies it's own URL or redirects to a browser
        // Using page objects to identify an element and click on that element
       chrome.getHomeButton().click();
        //Comparing the text of that element to the expected text, and providing a message that describes the assertion
        softAssert.assertEquals(chrome.getWelcomeMessage(), expected, "Checking the welcome message");

        //Causes an exception to be thrown if any assertions fail, failing the test and printing information on the failure
        //This should be included in any method that contains assertions. SoftAssert is preferred over regular assertions
        softAssert.assertAll();
    }
}
