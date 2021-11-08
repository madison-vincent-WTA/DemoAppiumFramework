# Appium Framework

This README file is currently *Incomplete*

The project contains a framework for running Appium. The baseFramework branch contains a mostly blank framework with 1 example test in each platform. The testingFramework branch contains more detailed testing examples to work from. Both contain detailed comments throughout the code. 

The Framework was made using IntelliJ on MacOS, so file path's mentioned in code may need to be adjusted

## Installation

### Requirements:

1. Typical IntelliJ setup for TestNG including Java, Maven, Selenium, TestNG, Node.js (dependencies should already be in the pom.xml file) etc. <br>
    a. Currently the pom.xml file uses the following versions: Appium 7.5.1, Selenium 3.141.59, TestNG 7.4.0, Maven Surefire 3.0.0-M5 <br>
    b. If you have newer versions, update the version numbers in the pom.xml. Then right click on the pom.xml > Maven > Reload Project to load the dependencies 
2. Appium installation - I recommend the desktop client
3. XCode Installation (set up your preferred simulator)
4. Android Studio Installation (set up your preferred emulator, I recommend one that has access to the Play Store and therefore Chrome)
5. If doing testing on desktop browsers, insure they are installed. Safari will require you to allow automation within the developer menu (enabled in advanced settings)

### Creating your own repo with the code

Note: a great guide on Git exists at https://rogerdudler.github.io/git-guide/

1. Create a new repository in github for your project
2. Navigate to the repository. The page should be focused on Quick Setup and the bottom section should say "...or import code from another repository". Click "Import Code"
3. Paste in https://github.com/madison-vincent/DemoAppiumFramework.git and click "Begin Import"
4. The new repository should now be a copy of the Demo framework
5. Open the IDE and create a new project based on a Verified Code Source (Get form VCS on IntelliJ). Provide the URL to your new repository
6. Switch to the repo branch you want to view/work in. Run the following command (Replace baseFramework with testingFramework to checkout the branch with example tests): <br>
 git checkout baseFramework <br>
 git pull baseFramework
7. The code should be in place, as a check you can ensure that classes exist in src>main>java>com.Framework>Base

### Setting up for general testing

 1. Right click on the pom.xml > Maven > Reload Project
 3. You can now add the .app and .apk files to the project. I recommend moving them into src/main/resources within the project.
 4. Naviage to src>main>java>com.Framework>global.properties and open the file 
 5. Follow the provided instructions to update the fields where needed. The list of customizable fields is below: <br>
    a. Project Name (Used for saving screenshots and reports to the right location) <br>
    b. IP (Your IP Address is required to initialize the drivers and interact with appium) <br>
    c. App Directory (Where the apps are located in the project)<br>
    d. Webdriver Properties (Defining which browser you want to use for testing and the path to the driver) <br>
    e. Android Device (Name of the device you want to use in Android Studio uiautomatoor) <br>
    f. Android App (Name of the app you want to use for Android Automation <br>
    g. mobileBrowser (The name of the browser you want to use for Android) <br>
    h. iOS Device (The name of the device you want to use in Xcode XCUITest) <br>
    i. UDID (The ID of the iOS device you want to use) <br>
    j. iOS App (The name of the app that you want to use for iOS) <br>
 
### Additional set up for automation on browsers

If you plan on testing in browsers (NOT Web Views) or on dekstop browser, take the following steps: 

1. Locate the drivers within the project at src/main/resources
2. We need to check that we have the right drivers for the browsers we will be testing on. You should check the version of the browser you are using and then check that you are using the right driver version for that browser. Repeat this for all browsers you plan on testing with.
3. Some examples are included below, as of October/2021 I am using the following browser and driver versions: <br>
    a. "chromedriver web 93" is the chromedriver for desktop. It is currently version 93 and works with Chrome browser version 93. <br>
    b. "chromedriver 83" is the chromedriver for Android. It is currently version 83 and works with Chrome browser version 83 <br>
    c. "geckodriver 30" is the driver for Firefox on Desktop. It is currently version 30 and support Firefox Browser version 93 <br>
    d. "msedgedriver 95" is the driver for Edge on Desktop. It is currently version 95 and supports Edge browser version 95 <br>
    e. Safari does not require a driver at this time, for desktop or mobile
3. If you need to change the driver to match a newer version of your browser, simply replace the old driver with the new one. 
4. Dont forget to update the driver name in Global Properties (and location/path if it was changed)

## Usage

### Writing Tests

Note: Android's uiautomatorviewer typically does not work with the Appium server running. Stop the server before opening uiautomatorviewer

WEBVIEW on Android:
To identify the xpath for objects in a WebView, you will need to use remote debugging as uiautomatorviewer will not recognize elements in a WebView. Setup:
https://developer.chrome.com/docs/devtools/remote-debugging/

### Running Tests

1. Ensure Android Studio and Xcode are open. 
2. Open the simulator/emulator in both locations. They must be open for Appium to recognize them. If a physical device is plugged in it will likely use that, but the global properties file may still need to be updated to include the right device name and id
3. Ensure the Appium server is running
4. You should now be able to run tests. It should default to running using TestNG. <br>
   a. You can run tests by right clicking the class and selecting "Run" or by right clicking the "testng.xml" file and clicking "run". The testng file will executes all tests as detailed within the file. This is the best way to execute your entire suite of tests as well as particular groups, packages, classes etc. 
6. Test output will appear in the IDE as well as the Appium Server logs. 

### Test Reports

Several reports will be generated automatically once tests have been ran that have failed/passed. They can be access by right clicking the report > Open In > Browser > Select browser. They are found at the following locations:

Emailable Report: Detailed report with screenshots
test-output > emailable-report.html

Basic Report: Simple overall report without screenshots
test-output > index.html

ExtentReport: Visually pleasing and includes graphs, dashboard etc
test-output > Reports > htmlreport.html

I would recommend the Emailable Report when debugging as it includes the most detail as well as screenshots captured upon failed assertions

## Contributing

Please clone the repository and create a repository specific to your project to ensure that it remains untouched. If something in the framework should be changed please create a Pull Request and assign Madison Vincent as a reviewer for approval. 

## Support

If you need any help or have any questions/concerns please reach out to Madison Vincent for help (madison.vincent@wundermanthompson.com)
