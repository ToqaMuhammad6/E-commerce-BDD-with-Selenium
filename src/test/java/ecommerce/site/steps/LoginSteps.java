package ecommerce.site.steps;

import ecommerce.site.factory.DriverFactory;
import ecommerce.site.pages.LoginPage;
import ecommerce.site.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;
    RegistrationPage registrationPage;

    LoginPage loginPage;

    @Given("LUser opens the site \"(.*)\"$")
    public void openTheSiteForLogin(String url) {
        driver = DriverFactory.initDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigate(url);
    }

    @And("User clicks the login button from the homepage")
    public void goToLoginPageFromHome(){
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("User enters an email \"(.*)\"$")
    public void loginPageEmail(String emailInput){
        loginPage.loginEmail(emailInput);
    }

    @And("User enters a password \"(.*)\"$")
    public void loginPagePassword(String passwordInput){
        loginPage.loginPassword(passwordInput);
    }

    @Then("User clicks on the login button")
    public void clickLogInBtn(){
        loginPage.clickLogin();
    }

    @And("the login  option become log out")
    public void beLoggedIn(){
        boolean logOut= loginPage.canLogOut();
        Assert.assertTrue(logOut);
        System.out.println("no errors ha");


    }

    @And("error message for invalid email is displayed")
    public void inValidEmailError(){
        String expectedMessage= "Please enter a valid email address.";

        String actualMessage = loginPage.emailErrorMessage();
        Assert.assertEquals(actualMessage,expectedMessage, "invalid email");

    }

    @And("User can not login and error message displayed")
    public void loginFail(){
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        String actualMessage = loginPage.wrongEmailAndPasswordMessage();
        Assert.assertEquals(actualMessage,expectedMessage, "no account for this email");

    }



}
