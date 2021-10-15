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
        //Starting the Appium server if it is not already running
        service=startServer();
        //TODO change this to BeforeSuite?
        //Initializing the driver and supplying the application name
        AndroidDriver<AndroidElement> driver=capabilities("apiDemo");
        //TODO: Should this be removed from the base if it lives in the beforeTest? Or should the beforeTest itself be moved to Base?
        //TODO: Application name should only be supplied by Global Properties
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TODO: Supply helpful information on the above and it's function

        // TODO adding an afterTest (?) that also stops the server via lesson 105.. Thinking it needs to
        //  be in base if possible
        // TODO adding closing and opening the emulator to the before and after tests as well via lesson 105?
    }

   //TODO Add before and after tests to all test classes

    @AfterTest
    public void afterTest() {
        //Stopping the server if it is running, to ensure we dont run into any issues
        service=stopServer();
        //TODO Change this to AfterSuite instead
    }

    // Below is a great example of using descriptions, groups, enabling/disabling, page objects and data providers
//    //Note: The below parameterized test must be run from the XML file due to parameter dependencies
//    @Parameters({"URL"}) // TODO: needs to be added as a string in the test method and used in the test
    @Test (groups= {"smoke"}, enabled = true, dataProvider= "ClickTestData",dataProviderClass= HomePageData.class,
    description = "Both buttons on the home screen lead to the correct page")
    public void checkButtonFunction(String buttonName, String desc, String buttonText, String message) throws InterruptedException, MalformedURLException {
        //Searching for an element and clicking on it, based on the xpath which is partially supplied by the data provider
        WebElement element = driver.findElementByXPath("//android.widget.TextView[@content-desc='"+buttonName+"']");
        element.click();
        //Checking that the existing button text is the same as the expected text, and supplying a message for the Assertion
        //In this example, the message = "Checking Accessibility button text"
        //If the assertion fails it will print "Assertion: Checking animation button text <FAILED> "
        softAssert.assertEquals(android.getButtonText(desc), buttonText, message);
        //Pressing the "back" button on the device to return to the home screen
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //TODO: Creating this as an AfterTest to ensure we don't cause issues with screenshots

        //Causes an exception to be thrown if any assertions fail, failing the test and printing information on the failure
        //This should be included in any method that contains assertions. SoftAssert is preferred over regular assertions
        softAssert.assertAll();
    }
}

