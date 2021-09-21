import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.Framework.AndroidBase;
import com.Framework.AllTestData;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.AndroidAppPageObjects;


public class AndroidTests extends AndroidBase {

    AndroidAppPageObjects android = new AndroidAppPageObjects();

    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException
    {
        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (dataProvider= "ClickTestData",dataProviderClass= AllTestData.class)
    public void clickTest(String buttonName, String desc, String buttonText, String message) {
        WebElement element = driver.findElementByXPath("//android.widget.TextView[@content-desc='"+buttonName+"']");
        element.click();
        softAssert.assertEquals(android.getButtonText(desc), buttonText, message);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        softAssert.assertAll();
    }
// Above is a great example of using both page objects and data providers



}

