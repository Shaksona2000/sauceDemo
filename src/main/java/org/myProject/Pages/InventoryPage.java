package org.myProject.Pages;

import org.myProject.Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private WaitUtils waitUtils;


    private By inventoryContainer = By.id("inventory_container");
    private By addBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By cartPage = By.className("shopping_cart_link");
//    private By checkout = By.id("checkout");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);

    }

    public boolean isInventoryPageDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }
    public void addBackpackToCart(){
        driver.findElement(addBackpackToCart).click();
    }

    public void goToCartPage(){
        driver.findElement(cartPage).click();
    }
//    public void goToCheckout(){
//        driver.findElement(checkout).click();
//    }

    public void checkout(String firstName, String lastName, String postalCode){
        waitUtils.waitUntilVisible(this.firstName);
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.postalCode).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }

}
