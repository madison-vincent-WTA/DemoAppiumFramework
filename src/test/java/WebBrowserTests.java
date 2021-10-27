import com.Framework.Base.WebBrowserBase;
import org.testng.annotations.Test;

public class WebBrowserTests extends WebBrowserBase {

    @Test
    public void webTest() throws InterruptedException {
        getChromeDriver().get("https://linkedin.com");
        Thread.sleep(5000);
    }

}
