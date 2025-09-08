package ecommerce.site.steps;

import ecommerce.site.factory.DriverFactory;
import ecommerce.site.pages.RegistrationPage;
import ecommerce.site.pages.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WishListSteps {
    WebDriver driver;
    RegistrationPage registrationPage;
    WishListPage wishListPage;



    /*@Given("WUser opens the site {string}")
    public void userNavigateToTheSite(String url){
        driver = DriverFactory.initDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigate(url);
    }*/


    @And("User checks the wishlist is empty or not")
    public void userChecksTheWishListIsEmpty(){
        driver = DriverFactory.getDriver();
        wishListPage = new WishListPage(driver);
        wishListPage.clickTheWishListBtn();
        String wishListISEmpty= "The wishlist is empty!";
        Assert.assertEquals(wishListPage.wishListQuantity(), "(0)");
        Assert.assertEquals(wishListPage.wishListIsEmpty(), wishListISEmpty);

    }

    @When("User navigates to the homepage")
    public void UserGoesToTheHomePage(){
        wishListPage.goHomePage();
    }

    @And("User selects a products and adds it to the wishlist")
    public void addProductTOTheWishList(){
        wishListPage.addProductToWishList();
    }

    @And("User clicks the \"x\" icon to close the confirm bar")
    public void userClosesTheConfirmationBar(){
        wishListPage.closeThePopup();
    }

    @Then("User checks that the product added successfully")
    public void userChecksTheProductsAdded(){

        wishListPage.clickTheWishListBtn();
        Assert.assertNotEquals(wishListPage.wishListQuantity(), "(0)", "not empty");
        Assert.assertTrue(wishListPage.addedProduct().toLowerCase().contains("Apple".toLowerCase()));

    }

    @And("User deletes the product from the wishlist and check it's emptiness")
    public void removeItemFromWishListAndCheckItsEmptiness(){
        wishListPage.removeProduct();
        Assert.assertEquals(wishListPage.wishListQuantity(), "(0)");
        Assert.assertTrue(wishListPage.wishListIsEmpty().toLowerCase().contains("Empty".toLowerCase()));

    }


}
