import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import com.Framework.Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;




public class homePageTests extends Base {


    @BeforeTest
    public void totalValidation() throws IOException, InterruptedException
    {
        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clickTest() {
        driver.findElementByXPath("//android.widget.TextView[@text='Accessibility']").click();
    }


}

