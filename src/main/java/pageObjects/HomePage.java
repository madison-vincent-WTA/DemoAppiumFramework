package pageObjects;

import com.Framework.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

public class HomePage extends Base {

	public static WebElement element;

	public static WebElement getTextButton() {

		WebElement element = driver.findElementByXPath("//android.widget.TextView[@text='Accessibility Node Provider']");
		return element;

	}
}
