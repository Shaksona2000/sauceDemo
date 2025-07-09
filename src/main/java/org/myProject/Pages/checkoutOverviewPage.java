package org.myProject.Pages;

import org.myProject.Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutOverviewPage {
    private WebDriver driver;
    private WaitUtils waitUtils;
    private By finishButton = By.id("finish");

    public checkoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    public void clickFinish() {
        waitUtils.waitUntilClickable(finishButton);
        waitUtils.scrollToElement(finishButton);
        driver.findElement(finishButton).click();
    }
}


