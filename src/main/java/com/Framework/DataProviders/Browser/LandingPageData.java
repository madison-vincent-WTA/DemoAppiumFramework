package com.Framework.DataProviders.Browser;

import org.testng.annotations.DataProvider;

public class LandingPageData {

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
