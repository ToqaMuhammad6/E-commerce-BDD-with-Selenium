package ecommerce.site.pages;

import ecommerce.site.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By registerPage= By.cssSelector("a.ico-register");
    private final By femaleGender= By.id("gender-female");
    private final By firstName= By.id("FirstName");
    private final By lastName= By.id("LastName");
    private final By emailInput= By.id("Email");
    private final By companyDetails= By.id("Company");
    private final By passwordInput= By.id("Password");
    private final By confirmPassword= By.id("ConfirmPassword");
    private final By registerBtn= By.id("register-button");

    private final By registrationCompleted = By.cssSelector("div.result");

    private final By continueBtn = By.cssSelector("a.register-continue-button");

    private final By errorDisplayed= By.id("ConfirmPassword-error");

    private final By invalidEmailInput= By.id("Email-error");



    public void goToRegisterPage(){
        driver.findElement(registerPage).click();
    }

    public void genderSelection(){
        driver.findElement(femaleGender).click();
    }

    public void firstName(String firstname){

        driver.findElement(firstName).sendKeys(firstname);
    }

    public void lastName(String lastname){

        driver.findElement(lastName).sendKeys(lastname);
    }

    public void emailField(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void companyDetails(String companyDetailsField){
        driver.findElement(companyDetails).sendKeys(companyDetailsField);
    }

    public void passwordField(String password){

        driver.findElement(passwordInput).sendKeys(password);
    }

    public void confirmPassword(String confirmPasswordField){

        driver.findElement(confirmPassword).sendKeys(confirmPasswordField);
    }

    public void clickRegister(){

        driver.findElement(registerBtn).click();
    }

    public String completedRegister(){
        return driver.findElement(registrationCompleted).getText();
    }

    public void continueButton(){
        driver.findElement(continueBtn).click();
    }

    public String errorMessage(){
        return driver.findElement(errorDisplayed).getText();
    }

    public String activeElementAsAString(){
        driver.findElement(registerBtn).click();
        return driver.switchTo().activeElement().getAttribute("outerHTML");
    }

    public String ActiveElementIdAfterRegisteration(){
        driver.findElement(registerBtn).click();
        return driver.switchTo().activeElement().getAttribute("id");
    }

    public String errorWithEmail(){
        return driver.findElement(invalidEmailInput).getText();
    }

}
