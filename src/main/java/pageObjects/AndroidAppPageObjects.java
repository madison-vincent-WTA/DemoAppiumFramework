package pageObjects;

import com.Framework.Base;
import org.openqa.selenium.WebElement;

public class AndroidAppPageObjects extends Base {

	public static WebElement getTextButton() {
		WebElement element = driver.findElementByXPath("//android.widget.TextView[@text='Accessibility Node Provider']");
		return element;
	}

}
