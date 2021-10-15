import com.Framework.IOSBase;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
import pageObjects.IOS.AppHomePageObjects;

import java.io.IOException;

public class IOSTests extends IOSBase {

    AppHomePageObjects ios = new AppHomePageObjects();

@Test
public void clickAlertViews() throws IOException, InterruptedException {
    IOSDriver driver = DesiredCapabilities("UIKitCatalog");
    Thread.sleep(3000);
    driver.findElementByAccessibilityId("Alert Views").click();

    }
}
