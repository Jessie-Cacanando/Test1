package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    private WebDriver driver;
    
    // Constructor
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Locators
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    // Methods
    public void enterSearchQuery(String query) {
        driver.findElement(searchBox).sendKeys(query);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).submit();
    }
}
