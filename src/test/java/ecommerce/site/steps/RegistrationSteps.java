package ecommerce.site.steps;

import ecommerce.site.factory.DriverFactory;
import ecommerce.site.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationSteps {

    WebDriver driver;
    RegistrationPage registrationPage;

    @Given("RUser opens the site \"(.*)\"$")
    public void openTheSite(String url){
        driver= DriverFactory.initDriver();
        registrationPage= new RegistrationPage(driver);
        registrationPage.navigate(url);
    }

    @And("User clicks on the registration button from homepage")
    public void goToRegisterPageFromHome(){
        registrationPage.goToRegisterPage();
    }

    @When("User selects a gender")
    public void selectGender(){
        registrationPage.genderSelection();
    }

    @And("User fills the first name \"(.*)\"$")
    public void fillFirstName(String firstNameInput){
        registrationPage.firstName(firstNameInput);
    }

    @And("User fills the last name \"(.*)\"$")
    public void fillLastName(String lastNameInput){
        registrationPage.lastName(lastNameInput);
    }

    @And("User adds an email \"(.*)\"$")
    public void fillEmail(String email){
        registrationPage.emailField(email);
    }

    @And("User adds a company details \"(.*)\"$")
    public void fillCompanyDetails(String companyDetailsInput){
        registrationPage.companyDetails(companyDetailsInput);
    }

    @And("User adds a password \"(.*)\"$")
    public void fillPassword(String passwordInput){
        registrationPage.passwordField(passwordInput);
    }

    @And("User confirms the password \"(.*)\"$")
    public void fillConfirmPassword(String confirmPasswordInput){
        registrationPage.confirmPassword(confirmPasswordInput);
    }

    @And("User clicks on the resister button")
    public void register() {
        registrationPage.clickRegister();
    }

    @And("User should see a confirmation message")
    public void confirmMessage() throws InterruptedException {
        String expectedMessage= "Your registration completed";

       String actualMessage = registrationPage.completedRegister();
        Assert.assertEquals(actualMessage,expectedMessage, "Registration Completed");

    }

    @And("User clicks on continue button")
    public void clickContinue(){
        registrationPage.continueButton();

    }

    @And("error message displayed")
    public void errorMessageDisplayed(){
        String expectedMessage= "The password and confirmation password do not match.";

        String actualMessage = registrationPage.errorMessage();
        Assert.assertEquals(actualMessage,expectedMessage, "Registration Failed");
    }

    @And("error message for invalid email displayed")
    public void invalidInput(){
//        String activeElement= registrationPage.activeElementAsAString();
//        Assert.assertTrue(activeElement.contains("input") && activeElement.contains("email"),
//                "Expected email field to be focused after invalid signup, but focus is on: " + activeElement);

        String activeElementId = registrationPage.ActiveElementIdAfterRegisteration();
        Assert.assertEquals(activeElementId, "Email", "Expected active Element Id to be Email");

        String expectedMessage= "Please enter a valid email address.";
        String actualMessage = registrationPage.errorWithEmail();
        Assert.assertEquals(actualMessage,expectedMessage, "Email Invalid");

    }



}
