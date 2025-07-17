package myProject.Tests;

import org.myProject.Utils.BaseTest;
import org.myProject.Pages.InventoryPage;
import org.myProject.Pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(org.myProject.Listeners.VideoListener.class)

public class PurchaseTest extends BaseTest {

    @Test(description = "Simulate simple login and landing")
    public void testAddToCartScenario() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        assert inventoryPage.isInventoryPageDisplayed();

        // Extend further with add to cart, checkout steps
    }
}
