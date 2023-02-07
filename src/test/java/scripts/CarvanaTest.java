package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaHomeBasePage;
import pages.MercedesBasePage;
import utilities.Waiter;


public class CarvanaTest extends CarvanaBase {

    @BeforeMethod
    public void setPage(){
        carvanaHomeBasePage = new CarvanaHomeBasePage();
        mercedesBasePage = new MercedesBasePage();
    }

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void ValidateTitleAndUrl(){
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2,description = "Validating the Carvana logo")
    public void ValidateCarvanaLogo(){
        Assert.assertTrue(carvanaHomeBasePage.carvanaLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Then validate the navigation section items below are displayed")
    public void ValidateNavigationSection(){

        for (int i = 0; i < carvanaHomeBasePage.navigationSection.size(); i++) {
            Assert.assertTrue(carvanaHomeBasePage.navigationSection.get(i).isDisplayed());
        }
    }

    @Test(priority = 4, description = "Validating the sign in error message")
    public void ValidateSignInError(){

        carvanaHomeBasePage.signInButtonHomePage.click();
        Waiter.pause(3);
        carvanaHomeBasePage.emailInput.sendKeys("johndoe@gmail.com");
        carvanaHomeBasePage.continueButton.click();
        carvanaHomeBasePage.passwordField.sendKeys("abcd1234");
        carvanaHomeBasePage.signInButton.click();
        Assert.assertEquals(carvanaHomeBasePage.errorMessage.getText(),
                "Email address and/or password combination is incorrect.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void ValidateSearchFilter(){

        carvanaHomeBasePage.searchCarsTab.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/cars");
        for (int i = 0; i < carvanaHomeBasePage.filterOptions.size(); i++) {
            Assert.assertTrue(carvanaHomeBasePage.filterOptions.get(i).isDisplayed());
        }
    }

    @Test(priority = 6, description = "Validate the search result tiles")
    public void ValidateSearchResult(){
        mercedesBasePage.searchCarsTab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        Waiter.pause(2);
        mercedesBasePage.searchButton.sendKeys("mercedes benz");
        Waiter.pause(2);
        mercedesBasePage.goButton.click();
        Waiter.pause(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));


        for (int i = 0; i < mercedesBasePage.tileBody.size(); i++) {

            Assert.assertTrue(mercedesBasePage.tileBody.get(i).isDisplayed());

            Assert.assertTrue(mercedesBasePage.image.get(i).isDisplayed());

            Assert.assertTrue(mercedesBasePage.favoriteButton.get(i).isDisplayed());

            Assert.assertTrue(mercedesBasePage.inventoryType.get(i).isDisplayed());

            Assert.assertTrue(mercedesBasePage.makeAndModel.get(i).isDisplayed());

            Assert.assertTrue(mercedesBasePage.trimAndMileage.get(i).isDisplayed());

            Assert.assertTrue(Integer.parseInt(mercedesBasePage.price.get(i).getText()
                    .replace("$","").replace(",", "")) > 0);

            Assert.assertTrue(mercedesBasePage.monthlyPayment.get(i).isDisplayed());

            Assert.assertTrue(mercedesBasePage.downPayment.get(i).isDisplayed());

            Assert.assertTrue(mercedesBasePage.ship.get(i).isDisplayed());
        }
    }

}
