package org.myProject.Pages;

import org.myProject.Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutYourInfo {
    private WebDriver driver;
    private WaitUtils waitUtils;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    public checkoutYourInfo(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void fillUserInfo(String fName, String lName, String zip) {
        waitUtils.waitUntilVisible(firstName);
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueButton).click();
    }
}
