import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import com.Framework.AndroidBase;
import com.Framework.DataProviders.Android.HomePageData;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Android.AppHomePageObjects;

@Listeners(com.Framework.Listeners.Listeners.class)
//TODO need to add listeners to other classes?

public class AndroidTests extends AndroidBase {

    AppHomePageObjects android = new AppHomePageObjects();

    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException
    {
        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // TODO adding an afterTest (?) that also stops the server via lesson 105.. Thinking it needs to
        //  be in base if possible
        // TODO adding closing and opening the emulator to the before and after tests as well via lesson 105?
    }

   //TODO Add before and after tests to all test classes

    @AfterTest
    public void afterTest() {
        service=stopServer();
        //TODO additional tests to test this functionality
    }

    //Note: The below parameterized test must be run from the XML file due to parameter dependencies
    @Parameters({"URL"}) // TODO: needs to be added as a string in the test method and used in the test
    @Test (groups= {"smoke"}, enabled = true, dataProvider= "ClickTestData",dataProviderClass= HomePageData.class,
    description = "Both buttons on the home screen lead to the correct page")
    public void checkButtonFunction(String buttonName, String desc, String buttonText, String message) throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = driver.findElementByXPath("//android.widget.TextView[@content-desc='"+buttonName+"']");
        element.click();
        Thread.sleep(3000);
        try {
            softAssert.assertEquals(android.getButtonText(desc), buttonText, message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(3000);
        softAssert.assertAll();
    }
// Above is a great example of using both page objects and data providers



}

