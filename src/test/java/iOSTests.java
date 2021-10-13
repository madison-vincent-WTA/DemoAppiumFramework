import com.Framework.iOSBase;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
import pageObjects.iOS.AppHomePageObjects;

import java.io.IOException;

public class iOSTests extends iOSBase {

    AppHomePageObjects ios = new AppHomePageObjects();

@Test
public void clickAlertViews() throws IOException, InterruptedException {
    IOSDriver driver = DesiredCapabilities("UIKitCatalog");
    Thread.sleep(3000);
    driver.findElementByAccessibilityId("Alert Views").click();

    }
}
