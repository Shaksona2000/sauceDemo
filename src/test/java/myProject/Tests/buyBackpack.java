package myProject.Tests;


import org.myProject.Pages.*;
import org.myProject.Utils.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.myProject.Listeners.VideoListener.class)

public class buyBackpack extends BaseTest {
    @Test(description = "Add backpack to cart and verify it appears in the cart")
    public void testAddToCartScenario() {
    LoginPage login = new LoginPage(driver);
    login.login("standard_user", "secret_sauce");
    InventoryPage inventory = new InventoryPage(driver);
    inventory.addBackpackToCart();
    inventory.goToCartPage();


    checkoutPage checkout = new checkoutPage(driver);
    checkout.clickCheckout();

    checkoutYourInfo checkoutInformation = new checkoutYourInfo(driver);
    checkoutInformation.fillUserInfo("shalva", "beridze", "12345");
        checkoutOverviewPage checkoutOverview = new checkoutOverviewPage(driver);
        checkoutOverview.clickFinish();

    }
}