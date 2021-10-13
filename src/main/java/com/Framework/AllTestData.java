package com.Framework;

import org.testng.annotations.DataProvider;

public class AllTestData {

	@DataProvider(name="ClickTestData")
	public Object[][] getButton()
	{
		//Below you can see multiple data sets, which will run through the test multiple times
		Object[][] buttons=new Object[][]
				{
						{"Accessibility", "Accessibility Node Provider", "Accessibility Node Provider1", "Checking accessibility button text"},
						{"Animation", "Bouncing Balls", "Bouncing Balls", "Checking animation button text"}
				};
				return buttons;
	}

	// Below is another example of how a data provider could be structured
	@DataProvider(name="ClickTestData2")
	public static Object[][] getButton2()
	{
		Object[][] buttons=new Object[2][4]; //This shows the object as containing 2 rows and 3 columns

		// The first set of  data
		buttons[0][0]="Accessibility";
		buttons[0][1]="Accessibility Node Provider";
		buttons[0][2]="Accessibility Node Provider";
		buttons[0][3]="Checking accessibility button text";

		// The second set of data
		buttons[1][0]="Animation";
		buttons[1][1]="Bouncing Balls";
		buttons[1][2]="Bouncing Balls";
		buttons[1][3]="Checking animation button text";

		return buttons;
	}

	@DataProvider(name="BrowserTestData")
	public static Object[][] getWelcomeMessage()
	{
		//You can store many values here as an array, or just one
		Object expected[][]=new Object[][]
				{
						{"Welcome to your professional community"}
				};
		return expected;
	}

}
