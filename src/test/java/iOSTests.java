import com.Framework.IOSBase;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
import pageObjects.iOSPageObjects;

import java.io.IOException;
import java.net.MalformedURLException;

public class IOSTests extends IOSBase {

    iOSPageObjects ios = new iOSPageObjects();

@Test
public void clickAlertViews() throws IOException, InterruptedException {
    IOSDriver driver = DesiredCapabilities("UIKitCatalog");
    Thread.sleep(3000);
    driver.findElementByAccessibilityId("Alert Views").click();

    }
}
