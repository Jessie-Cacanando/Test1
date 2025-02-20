package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.automation.pages.BasePage;
import com.automation.pages.GoogleSearchPage;
import com.automation.utils.ExtentManager;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.*;

public class GoogleSearchTest {
    private WebDriver driver;
    private GoogleSearchPage googlePage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setup() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void initializeTest() {
        BasePage.initialize();
        driver = BasePage.driver;
        googlePage = new GoogleSearchPage(driver);
    }

    @Test
    public void testGoogleSearch() {
        test = extent.createTest("Google Search Test");

        driver.get("https://www.google.com");
        test.info("Navigated to Google");

        googlePage.enterSearchQuery("Selenium WebDriver");
        test.info("Entered search query");

        googlePage.clickSearchButton();
        test.info("Clicked search button");

        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "GoogleSearchTest");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @AfterMethod
    public void tearDown() {
        BasePage.quit();
        extent.flush();
    }
}
