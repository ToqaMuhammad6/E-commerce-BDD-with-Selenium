package ecommerce.site.pages;

import ecommerce.site.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginPage= By.cssSelector("a.ico-login");
    private final By emailField= By.id("Email");
    private final By passwordField= By.id("Password");
    private final By emailError= By.id("Email-error");
    private final By notRegister= By.cssSelector("div.message-error.validation-summary-errors");
    private final By loginBtn= By.cssSelector("button.login-button");

    private final By logoutBtn = By.cssSelector("a.ico-logout");

    public void goToLoginPage(){

        driver.findElement(loginPage).click();
    }

    public void loginEmail(String emailInput){

        driver.findElement(emailField).sendKeys(emailInput);
    }

    public void loginPassword(String passwordInput){

        driver.findElement(passwordField).sendKeys(passwordInput);
    }

    public void clickLogin(){

        driver.findElement(loginBtn).click();
    }

    public boolean canLogOut(){

        return driver.findElement(logoutBtn).isDisplayed();
    }

    public String emailErrorMessage(){

        return driver.findElement(emailError).getText();
    }

    public String wrongEmailAndPasswordMessage(){

        return driver.findElement(notRegister).getText();
    }




}
