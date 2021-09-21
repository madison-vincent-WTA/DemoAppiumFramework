import com.Framework.BrowserBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class BrowserTests extends BrowserBase {

    @Test
    public void testName() throws IOException, InterruptedException {
       WebDriver driver = capabilities("chrome");

       driver.get("https://linkedin.com");


    }
}
