package ecommerce.site.pages;

import ecommerce.site.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutAndPaymentPage extends BasePage {
    public CheckOutAndPaymentPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);


    private final By cartBtn = By.cssSelector("#topcartlink");
    private final By cartQuantity = By.cssSelector("#topcartlink .cart-qty");
    private final By cartEmpty = By.cssSelector("div.no-data");
    private final By electronicsSection = By.cssSelector("a[href='/electronics']");
    private final By cameraSection = By.cssSelector("a[href='/camera-photo']");
    private final By selectAProduct = By.cssSelector("a[href='/apple-icam']");
    private final By addProduct = By.cssSelector("#add-to-cart-button-17");
    private final By theAddedProduct = By.xpath("//a[@href='/apple-icam' and text()='Apple iCam']");
    private final By closePopup = By.cssSelector("span.close[title='Close']");
    private final By closedBarSuccessfully = By.cssSelector(".bar-notification.success");
    private final By goToCartBtn = By.cssSelector("button.button-1.cart-button");
    private final By productName = By.cssSelector("td.product a.product-name[href='/apple-icam']");
    private final By agreeOnTerms= By.cssSelector("#termsofservice");
    private final By checkOutBtn = By.cssSelector("#checkout");
    private final By continueAsGuest = By.cssSelector("button.button-1.checkout-as-guest-button");
    private final By firstName = By.cssSelector("#BillingNewAddress_FirstName");
    private final By lastName = By.cssSelector("#BillingNewAddress_LastName");
    private final By email = By.cssSelector("#BillingNewAddress_Email");
    private final By country = By.xpath("//option[text()='Egypt']");
    private final By state = By.xpath("//select[@id='BillingNewAddress_StateProvinceId']/option[text()='Alexandria']");
    private final By countryEG = By.id("BillingNewAddress_CountryId");
    private final By stateAlex = By.id("BillingNewAddress_StateProvinceId");
    private final By city = By.cssSelector("#BillingNewAddress_City");
    private final By address = By.cssSelector("#BillingNewAddress_Address1");
    private final By zipCode = By.cssSelector("#BillingNewAddress_ZipPostalCode");
    private final By phoneNumber = By.cssSelector("#BillingNewAddress_PhoneNumber");
    private final By continueBtn = By.cssSelector("button.button-1.new-address-next-step-button");
    private final By shippingOption = By.cssSelector("input[name='shippingoption'][value='Next Day Air___Shipping.FixedByWeightByTotal']");
    private final By  shippingContinueBtn = By.cssSelector("button.button-1.shipping-method-next-step-button");
    private final By payVisa = By.cssSelector("#paymentmethod_1");
    private final By paymentContinueBtn = By.cssSelector("button.payment-method-next-step-button");
    private final By visaType = By.id("CreditCardType");
    private final By cardholderName = By.name("CardholderName");
    private final By cardNumber = By.cssSelector("#CardNumber");
    private final By expireMonth = By.cssSelector("#ExpireMonth");
    private final By expireYear = By.cssSelector("#ExpireYear");
    private final By cardCode = By.cssSelector("#CardCode");
    private final By continuePaymentBtn = By.className("payment-info-next-step-button");
    private final By confirmBtn = By.cssSelector(".confirm-order-next-step-button");
    private final By successMessage = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    private final By continueToHomeBtn = By.cssSelector(".order-completed-continue-button");






    public void clickOnCartBtn(){
        driver.findElement(cartBtn).click();
    }

    public String cartQuantity(){
        return driver.findElement(cartQuantity).getText();
    }

    public String cartIsEmpty(){
        return driver.findElement(cartEmpty).getText();

    }

    public void goToTheCameraSection(){
        actions.moveToElement(driver.findElement(electronicsSection)).perform();
        actions.moveToElement(driver.findElement(cameraSection)).click().perform();
    }

    public void addProductToCart(){
        driver.findElement(selectAProduct).click();
        driver.findElement(addProduct).click();
    }

    public void closeThePopup(){
        driver.findElement(closePopup).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(closedBarSuccessfully));
    }

    public void hoverOnCart(){
        actions.moveToElement(driver.findElement(cartBtn)).perform();
    }
    public boolean isProductDisplayed() {
        return driver.findElement(theAddedProduct).isDisplayed();
    }

    public void goToCart(){
        this.hoverOnCart();
        actions.moveToElement(driver.findElement(goToCartBtn)).click().perform();

    }

    public String theAddedProduct(){
        return driver.findElement(productName).getText();
    }
    public void userAgreesOnTerms(){
        driver.findElement(agreeOnTerms).click();
    }

    public void userClickCheckOut(){
        driver.findElement(checkOutBtn).click();
        driver.findElement(continueAsGuest).click();

    }

    public void firstName(String firstname){

        driver.findElement(firstName).sendKeys(firstname);
    }

    public void lastName(String lastname){

        driver.findElement(lastName).sendKeys(lastname);
    }

    public void emailField(String emailInput){

        driver.findElement(email).sendKeys(emailInput);
    }

    public void selectCountry(String countrySelect, String stateSelect){
        //driver.findElement(country).click();
        //driver.findElement(state).click();
        Select selectCountry = new Select(driver.findElement(countryEG));
        selectCountry.selectByVisibleText(countrySelect);

        Select selectState = new Select(driver.findElement(stateAlex));

        selectState.selectByVisibleText(stateSelect);

    }

    public void cityField(String cityInput){

        driver.findElement(city).sendKeys(cityInput);
    }

    public void addressField(String addressInput){

        driver.findElement(address).sendKeys(addressInput);
    }

    public void zipCodeField(String zipCodeInput){

        driver.findElement(zipCode).sendKeys(zipCodeInput);
    }

    public void phoneNumberField(String phoneNumberInput){

        driver.findElement(phoneNumber).sendKeys(phoneNumberInput);
    }

    public void saveAddress(){
        driver.findElement(continueBtn).click();
    }

    public void shippingMethodSelection(){
        driver.findElement(shippingOption).click();
        driver.findElement(shippingContinueBtn).click();

    }

    public void payByVisa(){
        driver.findElement(payVisa).click();
        driver.findElement(paymentContinueBtn).click();
    }

    public void creditCardInfo(String typeCard,
                               String holderName,
                               String cardNum,
                               String expMonth,
                               String expYear,
                               String cardCvv) {

        // Type of Credit Card
        Select selectCardType = new Select(driver.findElement(visaType));
        selectCardType.selectByVisibleText(typeCard);

        //send card name
        driver.findElement(cardholderName).sendKeys(holderName);

        // send card num
        driver.findElement(cardNumber).sendKeys(cardNum);

        //expire Month
        Select selectExpireMonth = new Select(driver.findElement(expireMonth));
        selectExpireMonth.selectByVisibleText(expMonth);

        //expire Year
        Select selectExpireYear = new Select(driver.findElement(expireYear));
        selectExpireYear.selectByVisibleText(expYear);

        //send cvv
        driver.findElement(cardCode).sendKeys(cardCvv);

        driver.findElement(continuePaymentBtn).click();

    }

    public void confirmPaymentInfo(){
        driver.findElement(confirmBtn).click();
    }

    public String paymentSuccess(){
        return driver.findElement(successMessage).getText();

    }

    public String currentURL(){
        return driver.getCurrentUrl();
    }

    public void continueToHome(){
        driver.findElement(continueToHomeBtn).click();
    }


}
