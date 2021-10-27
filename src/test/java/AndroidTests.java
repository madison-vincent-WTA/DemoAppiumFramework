import java.io.IOException;
import java.net.MalformedURLException;

import com.Framework.AndroidBase;
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
        AndroidDriver<AndroidElement> driver=capabilities();
        //TODO: Should this be removed from the base if it lives in the beforeTest? Or should the beforeTest itself be moved to Base?

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
    @Test (groups= {"smoke"}, enabled = true, dataProvider= "ClickTestData", description = "Both buttons on the home screen lead to the correct page")
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

    @DataProvider(name="ClickTestData")
    public static Object[][] getButton()
    {
        //Below you can see multiple data sets, which will run through the test multiple times
        Object[][] buttons=new Object[][]
                {
                        {"Accessibility", "Accessibility Node Provider", "Accessibility Node Provider1", "Checking accessibility button text"},
                        {"Animation", "Bouncing Balls", "Bouncing Balls", "Checking animation button text"}
                };
        return buttons;
    }

    // Below is another example of how a data provider could be structured
    @DataProvider(name="ClickTestData2")
    public static Object[][] getButton2()
    {
        Object[][] buttons=new Object[2][4]; //This shows the object as containing 2 rows and 3 columns

        // The first set of  data
        buttons[0][0]="Accessibility";
        buttons[0][1]="Accessibility Node Provider";
        buttons[0][2]="Accessibility Node Provider";
        buttons[0][3]="Checking accessibility button text";

        // The second set of data
        buttons[1][0]="Animation";
        buttons[1][1]="Bouncing Balls";
        buttons[1][2]="Bouncing Balls";
        buttons[1][3]="Checking animation button text";

        return buttons;
    }
}

