# Selenium Automation Framework-Hybrid

[![N|Solid](http://www.seleniumhq.org/images/selenium-logo.png)](http://www.seleniumhq.org/) 

**This is a Hybrid (Keyword + DataDriven) framework. This is business oriented framework where you don't need to write much code instead just write test data in excel file with keyword/Action, Value, locators, locator type and expected results. Writing test cases is very simple. You can check sample test cases in HomePage and Category Module**

**Now no worry about to download and keep browser binary driver (geckoDriver.exe and chromedriver) on class-path as it will take care by **webdrivermanager** so no worry about compatibility issues between selenium and browser compatibility. You have to just keep selenium dependency  and browser on latest version.**


 - Designed and written in **JAVA**
 - Implemented using **TestNG**
 - Build Toold - **Maven**
 - Test data source file type- **Excel files** (no need to change code just add file and use key to fetch data)
 - Implemented with  **Module based**
 - Video Recording - Automation-Remarks

### Browsers Supported
 - Mozilla Firefox
 - Google Chrome
 - Internet Explorer

### Platform Support
 - Windows
 - Linux
 - Macintosh

---
### Reporting
 - [Extent Reporting](http://extentreports.com/)
 
---
### Usage
```sh
$ mvn clean test
```
---
### Browser Setup
 - Navigate to *.\src\main\resources* change *BrowserType* in the ZalandoConfig.properties
 or use Maven to invoke different browsers
---

### Report Details

**Report Location** `System.getProperty("user.dir") + "/src/test/resources/Reports/";`

**Failed Screenshots** `System.getProperty("user.dir") + "/src/test/resources/Reports/Images";`

**Video Location** `System.getProperty("user.dir") + "videos";`

**Test Data** `System.getProperty("user.dir") + "/src/test/resources/TestData";`

---


### Video Feature
 > _enabledALL_ -> To Save recorded video for All test case. Stored in `"./src/test/resources/Reports/Videos"`
 
 > _enabledFAILED_ -> To Save recorded video for ONLY FAILED test case. Stored in  `"./src/test/resources/Reports/Videos"`
 
 > _disabled_ -> To not save the video
 
 **NOTE :**

For browser browser_binaries, the WebDriverManager keeps downloading the latest version of binary of the chosen browser so it is better to make sure or re-assure from time to time that the Selenium API version works fine with the browser. Otherwise, an upgrade is necessary. Reason is, we need to keep to our browsers updated to latest so a latest version of Selenium API is a must (if it's proven stable).