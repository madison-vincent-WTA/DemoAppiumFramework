package com.demoAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class firstTests extends baseClass {

    public static void main(String[] args) throws MalformedURLException{

        // We are using the capabilities() method made in our baseClass to ensure we have access to the DesiredCapabilities we need
        AndroidDriver<AndroidElement> driver = capabilities();

        //Start adding tests now! yay!

    }

}
