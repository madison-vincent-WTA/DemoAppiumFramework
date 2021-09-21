package com.Framework;

import org.testng.annotations.DataProvider;

public class AllTestData {

	@DataProvider(name="ClickTestData")
	public Object[][] getButton()
	{
		//Below you can see multiple data sets, which will run through the test multiple times
		Object[][] buttons=new Object[][]
				{
			{"Accessibility", "Accessibility Node Provider", "Accessibility Node Provider", "Checking Accessibility Button"},
						{"Animation", "Bouncing Balls", "Bouncing Balls", "Checking Animation Button"}
				};
				return buttons;
	}

	@DataProvider(name="BrowserTestData")
	public Object[][] getWelcomeMessage()
	{
		//You can store many values here as an array, or just one
		Object expected[][]=new Object[][]
				{
						{"Welcome to your professional community"}
				};
		return expected;
	}

}
