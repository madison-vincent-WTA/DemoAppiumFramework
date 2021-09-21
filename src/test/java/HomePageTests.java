import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.Framework.Base;
import com.Framework.TestData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;


public class HomePageTests extends Base {


    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException
    {
        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (dataProvider="ClickTestData",dataProviderClass= TestData.class)
    public void clickTest(String obj) {
        driver.findElementByXPath("//android.widget.TextView[@text='"+obj+"']").click();
        // an example of using a data provider

    }

    @Test
    public void clickTest2() {
        HomePage.getTextButton().click();
        // an example of using page objects correctly

    }


}

