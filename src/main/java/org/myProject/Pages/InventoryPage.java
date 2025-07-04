package org.myProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    private By inventoryContainer = By.id("inventory_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInventoryPageDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }
}
