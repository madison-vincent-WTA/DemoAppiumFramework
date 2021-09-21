package com.Framework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="ClickTestData")
	public Object[][] getDataforEditField()
	{
		//You can store many values here as an array
		Object[][] obj=new Object[][]
				{
			{"Accessibility"}
				};
				return obj;
	}

}
