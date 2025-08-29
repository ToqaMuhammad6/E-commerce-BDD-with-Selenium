package ecommerce.site.pages;

import ecommerce.site.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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



    public void searchFor(String searchItem){
        driver.findElement(searchBar).sendKeys(searchItem);
    }

    public void searchButton(){
        driver.findElement(searchBtn).click();
    }

    public List<WebElement> listOfProducts(){
        return driver.findElements(resultList);


    }

    public List<String> loopThroughItems() {
        List<String> productNames = listOfProducts().stream()
                .map(item -> item.findElement(eachElement).getText().toLowerCase())
                .peek(name -> System.out.println("Checking product: " + name))
                .collect(Collectors.toList());


        return productNames;
    }

    public String errorWithResults(){

        return driver.findElement(searchError).getText();
    }


    public List<String> getRecommendedListTexts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> elements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(searchRecommended)
        );

        List<String> texts = elements.stream()
                .map(el -> el.getText().trim())
                .filter(text -> !text.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toList());


        return texts;
    }






}



