package com.Framework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="ClickTestData")
	public Object[][] getDataforEditField()
	{
		//2 sets of data, "hello" , "!@#$$"
		Object[][] obj=new Object[][]
				{
			
			{"Accessibility"}
				};
				
				return obj;
				
	}

}
