package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base {

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateCarvanaHomePage() {
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateLogo() {
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(homePage.logo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainNavigationItems() {
        driver.get("https://www.carvana.com/");
        Waiter.pause(2);
        homePage.navigationIsDisplayed("HOW IT WORKS");
        Waiter.pause(2);
        homePage.navigationIsDisplayed("ABOUT CARVANA");
        Waiter.pause(2);
        homePage.navigationIsDisplayed("SUPPORT & CONTACT");
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void testingSignIn() {
        driver.get("https://www.carvana.com/");
        Waiter.pause(2);
        homePage.signInButton.click();
        Waiter.pause(2);
        Assert.assertTrue(homePage.signInModal.isDisplayed());
        homePage.emailInputBox.sendKeys("johndoe@gmail.com");
        homePage.passwordInputBox.sendKeys("abcd1234");
        homePage.signInModalButton.click();
        Waiter.pause(2);
        Assert.assertEquals(homePage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchFilterAndButton() {
        driver.get("https://www.carvana.com/");
        Waiter.pause(2);
        homePage.searchCarsLink.click();
        Waiter.pause(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        String[] optionsText = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(carSearchPage.filterOptions.get(i).isDisplayed());
            Assert.assertEquals(carSearchPage.filterOptions.get(i).getText(), optionsText[i]);
        }
    }


    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateResultCards() {
        driver.get("https://www.carvana.com/");
        Waiter.pause(2);
        homePage.searchCarsLink.click();
        Waiter.pause(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carSearchPage.searchInputBox.sendKeys("mercedes-benz");
        carSearchPage.goButton.click();
        Waiter.pause(2);

        for (int i = 0; i < carSearchPage.tiles.size(); i++) {
            Assert.assertTrue(carSearchPage.tiles.get(i).isDisplayed());
            Assert.assertTrue(carSearchPage.tileFavoriteButton.get(i).isDisplayed());
            Assert.assertTrue(carSearchPage.tilesImage.get(i).isDisplayed());

            Assert.assertTrue(carSearchPage.makeModel.get(i).isDisplayed());
            Assert.assertNotNull(carSearchPage.makeModel.get(i).getText());

            Assert.assertTrue(carSearchPage.trimMileage.get(i).isDisplayed());
            Assert.assertNotNull(carSearchPage.trimMileage.get(i).getText());

            Assert.assertTrue(carSearchPage.price.get(i).isDisplayed());
            Assert.assertNotNull(carSearchPage.price.get(i).getText());

            Assert.assertTrue(carSearchPage.monthlyPayment.get(i).isDisplayed());
            Assert.assertNotNull(carSearchPage.monthlyPayment.get(i).getText());

            Assert.assertTrue(carSearchPage.downPayment.get(i).isDisplayed());
            Assert.assertNotNull(carSearchPage.downPayment.get(i).getText());

            Assert.assertTrue(carSearchPage.deliveryChip.get(i).isDisplayed());
            Assert.assertNotNull(carSearchPage.deliveryChip.get(i).getText());
        }
    }
}
