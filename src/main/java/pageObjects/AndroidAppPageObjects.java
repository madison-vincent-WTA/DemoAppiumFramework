package pageObjects;

import com.Framework.AndroidBase;
import org.openqa.selenium.WebElement;

public class AndroidAppPageObjects extends AndroidBase {

	public static String getButtonText(String desc) {
		String xpath = "//android.widget.TextView[@text='"+desc+"']";
		waitForElement(driver.findElementByXPath(xpath), 10, 1);
		WebElement element = driver.findElementByXPath(xpath);
		String text = element.getText();
		return text;
	}

}
