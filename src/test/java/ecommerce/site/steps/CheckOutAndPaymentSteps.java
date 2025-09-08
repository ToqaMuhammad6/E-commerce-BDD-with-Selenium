package ecommerce.site.steps;

import ecommerce.site.factory.DriverFactory;
import ecommerce.site.pages.CheckOutAndPaymentPage;
import ecommerce.site.pages.RegistrationPage;
import ecommerce.site.pages.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutAndPaymentSteps {

    WebDriver driver;
    RegistrationPage registrationPage;

    CheckOutAndPaymentPage checkOutAndPaymentPage;



    /*@Given("CUser opens the site {string}")
    public void userNavigateToTheSite(String url){
        driver = DriverFactory.initDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigate(url);
    }*/


    @And("User checks the shopping cart is empty or not")
    public void userChecksTheCartIsEmpty(){
        driver = DriverFactory.getDriver();
        checkOutAndPaymentPage = new CheckOutAndPaymentPage(driver);
        checkOutAndPaymentPage.clickOnCartBtn();
        String cartISEmpty= "Your Shopping Cart is empty!";
        Assert.assertEquals(checkOutAndPaymentPage.cartQuantity(), "(0)");
        Assert.assertEquals(checkOutAndPaymentPage.cartIsEmpty(), cartISEmpty);

    }

    @When("User selects camera and photo option when hover the electronics section")
    public void UserGoesToTheElectronicsSection(){

        checkOutAndPaymentPage.goToTheCameraSection();
    }

    @And("User selects a products and adds it to the cart")
    public void addProductTOTheWishList(){

        checkOutAndPaymentPage.addProductToCart();
    }

    @And("User clicks the \"x\" icon to close the confirmation bar")
    public void userClosesTheConfirmationBar(){

        checkOutAndPaymentPage.closeThePopup();
    }

    @Then("User checks that the product added to the cart successfully")
    public void userChecksTheProductsAddedToCart(){

        Assert.assertNotEquals(checkOutAndPaymentPage.cartQuantity(), "(0)", "not empty");
        checkOutAndPaymentPage.hoverOnCart();
        Assert.assertTrue(checkOutAndPaymentPage.isProductDisplayed());

    }

    @And("User hover over the shopping cart button and click go to cart")
    public void userGoToCartPage(){
        checkOutAndPaymentPage.goToCart();
    }

    @And("User check the product name is the same in the cart page")
    public void userCheckTheProductInCartPage(){
        Assert.assertTrue(checkOutAndPaymentPage.theAddedProduct().toLowerCase().contains("Apple".toLowerCase()));
    }

    @And("User agrees on terms and conditions")
    public void userAgreesOnTermsOfService(){
        checkOutAndPaymentPage.userAgreesOnTerms();
    }

    @And("User clicks on the checkout button")
    public void userClickTheCheckOutButton(){
        checkOutAndPaymentPage.userClickCheckOut();
    }

    @And("User fills first name {string}")
    public void fillFirstName(String firstNameInput){
        checkOutAndPaymentPage.firstName(firstNameInput);
    }

    @And("User fills last name {string}")
    public void fillLastName(String lastNameInput){

        checkOutAndPaymentPage.lastName(lastNameInput);
    }

    @And("User enters a valid email {string}")
    public void fillEmail(String userEmail){

        checkOutAndPaymentPage.emailField(userEmail);
    }

    @And("User selects the country and state {string} {string}")
    public void selectTheCountry(String country, String state){
        checkOutAndPaymentPage.selectCountry(country,state);
    }

    @And("User adds the city {string}")
    public void fillTheCity(String cityInput){

        checkOutAndPaymentPage.cityField(cityInput);
    }
    @And("User adds the address {string}")
    public void fillTheAddress(String addressInput){

        checkOutAndPaymentPage.addressField(addressInput);
    }

    @And("User adds a zip code {string}")
    public void fillTheZipCode(String zipCodeInput){

        checkOutAndPaymentPage.zipCodeField(zipCodeInput);
    }

    @And("User adds a phone number {string}")
    public void fillThePhoneNumber(String phoneNum){

        checkOutAndPaymentPage.phoneNumberField(phoneNum);
    }

    @Then("User clicks the continue button")
    public void userClicksOnContinueButton(){
        checkOutAndPaymentPage.saveAddress();
    }

    @And("User choose a shipping method and continue")
    public void userChooseAShippingMethodAndContinue(){
        checkOutAndPaymentPage.shippingMethodSelection();
    }

    @And("User Select payment via visa")
    public void userChooseAPaymentMethodAndContinue(){
        checkOutAndPaymentPage.payByVisa();
    }

    @And("User fill the payment information {string} {string} {string} {string} {string} {string} and user click continue")
    public void fillThePaymentInfo(String cardType,
                                   String cardHolder,
                                   String cardNum,
                                   String expMonth,
                                   String expYear,
                                   String cvv){

        checkOutAndPaymentPage.creditCardInfo(cardType,
                cardHolder,
                cardNum,
                expMonth,
                expYear,
                cvv);
    }

    @Then("User clicks on the Confirm button")
    public void confirmPayment(){
        checkOutAndPaymentPage.confirmPaymentInfo();
    }

    @And("User checks that the order is successfully completed")
    public void checkPaymentSuccess(){
        String expectedSuccessText= "Your order has been successfully processed!";
        String expectedSuccessUrl= "https://demo.nopcommerce.com/checkout/completed";
        Assert.assertEquals(checkOutAndPaymentPage.paymentSuccess().toLowerCase(), expectedSuccessText.toLowerCase());
        Assert.assertEquals(checkOutAndPaymentPage.currentURL(), expectedSuccessUrl, "The current URL does not match the expected URL.");

    }

    @And("User clicks continue and goes to homepage")
    public void userContinueToHomePage(){
        checkOutAndPaymentPage.continueToHome();
    }




}
