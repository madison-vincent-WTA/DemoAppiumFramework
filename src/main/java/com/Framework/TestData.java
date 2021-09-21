package com.Framework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="ClickTestData")
	public Object[][] getButton()
	{
		//You can store many values here as an array
		Object[][] obj=new Object[][]
				{
			{"Accessibility"}
				};
				return obj;
	}

	@DataProvider(name="BrowserTestData")
	public Object[][] getWelcomeMessage()
	{
		//You can store many values here as an array
		Object[][] expected=new Object[][]
				{
						{"Welcome to your professional community"}
				};
		return expected;
	}

}
