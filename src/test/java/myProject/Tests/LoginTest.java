package myProject.Tests;

import org.myProject.Utils.BaseTest;
import org.myProject.Pages.InventoryPage;
import org.myProject.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.myProject.Listeners.VideoListener.class)

public class LoginTest extends BaseTest {

    @Test(description = "Valid login test")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page should be visible.");
    }

    @Test(dataProvider = "invalidLoginData", description = "Invalid login test with wrong credentials")
    public void testInvalidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"), "Error message should be shown.");
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"invalid_user", "secret_sauce"},
                {"standard_user", "wrong_password"},
                {"", ""}
        };
    }
}