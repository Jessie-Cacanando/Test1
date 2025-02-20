package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    public static WebDriver driver;

    public static void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
