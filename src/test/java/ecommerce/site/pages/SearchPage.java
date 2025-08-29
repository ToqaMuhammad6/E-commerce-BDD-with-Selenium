package ecommerce.site.pages;

import ecommerce.site.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By searchBar = By.cssSelector("#small-searchterms");
    private final By searchBtn = By.cssSelector("button.search-box-button");
    private final By searchRecommended = By.cssSelector(".ui-autocomplete li");
    private final By resultList = By.cssSelector("div.item-grid .product-item");

    private final By eachElement = By.cssSelector(".product-title a");

    private final By searchError = By.cssSelector("div.warning");



    public void searchForWord(String searchItem){
        driver.findElement(searchBar).sendKeys(searchItem);
    }

    public void searchButton(){
        driver.findElement(searchBtn).click();
    }

    public List<WebElement> listOfProducts(){
        return driver.findElements(resultList);


    }

    public List<String> loopThroughItems() {
        List<String> productNames = new ArrayList<>();


        for (int i = 0; i < listOfProducts().size(); i++) {
            WebElement item = listOfProducts().get(i);

            // Find the element that contains the product name/title within each item.
            // You might need to adjust this locator depending on the HTML structure.
            // A common locator is to find the heading or a specific link.
            WebElement productNameElement = item.findElement(eachElement);

            // Get the text of the product name and convert to lower case for case-insensitive comparison.
            String productName = productNameElement.getText().toLowerCase();
            productNames.add(productName);

            // Get the expected term and convert to lower case.
            System.out.println("Checking product #" + (i + 1) + ": " + productName);

        }
        return productNames;
    }

    public String errorWithResults(){

        return driver.findElement(searchError).getText();
    }

    /*public List<WebElement> recommendList(){
        return driver.findElements(searchRecommended);
    }*/

    public List<String> getRecommendedListTexts() {
        //List<WebElement> elements = driver.findElements(searchRecommended);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> elements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(searchRecommended)
        );
        List<String> texts = new ArrayList<>();

        for (WebElement el : elements) {
            String text = el.getText().trim();
            if (!text.isEmpty()) {   // only add non-empty values
                texts.add(text.toLowerCase());
            }

        }
        return texts;
    }






}



