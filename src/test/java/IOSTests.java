import com.Framework.IOSBase;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
import pageObjects.IOS.AppHomePageObjects;

import java.io.IOException;

public class IOSTests extends IOSBase {

    AppHomePageObjects ios = new AppHomePageObjects();

@Test
public void clickAlertViews() throws IOException, InterruptedException {
    IOSDriver driver = DesiredCapabilities();
    //TODO call the driver from the base as it isn't needed her or should at least be parameterized
    Thread.sleep(3000);
    //Finding an element based on ID and clicking on it
    driver.findElementByAccessibilityId("Alert Views").click();
    }
    //TODO: Everything - assertion, examples of ios interactions, test dependecy, priorities, xpath etc
}
