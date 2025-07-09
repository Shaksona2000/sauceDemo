package org.myProject.Pages;

import org.myProject.Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutPage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    private By checkoutButton = By.id("checkout");

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void clickCheckout() {
        waitUtils.waitUntilClickable(checkoutButton);
        driver.findElement(checkoutButton).click();
    }
}
