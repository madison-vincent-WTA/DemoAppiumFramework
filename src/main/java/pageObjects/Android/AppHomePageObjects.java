package pageObjects.Android;

import com.Framework.AndroidBase;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class AppHomePageObjects extends AndroidBase {

	public static String getButtonText(String desc) throws MalformedURLException {
		String xpath = "//android.widget.TextView[@text='"+desc+"']";
		waitForElement(driver.findElementByXPath(xpath), 10, 1);
		WebElement element = driver.findElementByXPath(xpath);
		String text = element.getText();
		return text;
	}

}
