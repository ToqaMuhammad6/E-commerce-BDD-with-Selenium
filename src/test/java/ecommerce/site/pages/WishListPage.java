package ecommerce.site.pages;

import ecommerce.site.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishListPage extends BasePage {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    private final By wishListBtn= By.cssSelector("a.ico-wishlist");
    private final By wishListQuantity= By.cssSelector("span.wishlist-qty");
    private final By wishlistempty = By.cssSelector("div.no-data");

    private final By homePage = By.cssSelector("img[alt='nopCommerce demo store']");

    private final By selectProduct = By.cssSelector("div.product-item[data-productid='4']");
    private final By addProduct = By.cssSelector("button.add-to-wishlist-button[data-productid='4']");

    private final By closePopup = By.cssSelector("span.close[title='Close']");

    private final By closedBarSuccessfully = By.cssSelector(".bar-notification.success");

    private final By addedProductToWishList = By.cssSelector("a.product-name[href='/apple-macbook-pro']");

    private final By removeProductFromWishList = By.cssSelector("td.remove-from-cart button.remove-btn");



    public void clickTheWishListBtn(){
        driver.findElement(wishListBtn).click();
    }


    public String wishListQuantity(){
            return driver.findElement(wishListQuantity).getText();
    }

    public String wishListIsEmpty(){
        return driver.findElement(wishlistempty).getText();

    }

    public void goHomePage(){
        driver.findElement(homePage).click();
    }

    public void addProductToWishList(){
        driver.findElement(selectProduct).click();
        driver.findElement(addProduct).click();
    }

    public void closeThePopup(){
        driver.findElement(closePopup).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(closedBarSuccessfully));
    }

    public String addedProduct(){
        return driver.findElement(addedProductToWishList).getText();
    }

    public void removeProduct(){
        driver.findElement(removeProductFromWishList).click();

    }





}
