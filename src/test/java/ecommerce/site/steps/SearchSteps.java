package ecommerce.site.steps;

import ecommerce.site.factory.DriverFactory;
import ecommerce.site.pages.RegistrationPage;
import ecommerce.site.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

public class SearchSteps {

    WebDriver driver;
    RegistrationPage registrationPage;
    SearchPage searchPage;
    private String lastSearchTerm;

    @Given("SUser opens the site \"(.*)\"$")
    public void openTheSiteForLogin(String url) {
        driver = DriverFactory.initDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigate(url);
    }

    @When("User enters a word for search {string}")
    public void searchForAProduct(String searchWord) {
        searchPage = new SearchPage(driver);
        searchPage.searchForWord(searchWord);
    }

    @And("User clicks on the search button")
    public void clickOnTheSearchBtn() {
        searchPage.searchButton();
    }

    /*@And("User scroll to see the results")
    public void scrollThroughTheResults() {
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }*/

    @Then("User finds the results contain the same word of the search {string}")
    public void resultsOFTheSearch(String expectedTerm) {
        /* resultContainer = searchPage.keyWord();

        Assert.assertTrue(resultContainer.isDisplayed());

        Assert.assertTrue(driver.getTitle().contains(expectedTerm));
        System.out.println(expectedTerm);*/

         // Adjust locator
        //Assert.assertTrue(resultsContainer.isDisplayed());
        // Optionally, assert the title or a specific text indicating the search term
        //Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTerm.toLowerCase()));
        //WebElement productName = firstResult.findElement(By.cssSelector("img[alt='Picture of Samsung Premium Ultrabook']")); //worked
        // Assert.assertTrue(productName.getText().toLowerCase().contains(expectedTerm.toLowerCase()));

        //Assert.assertFalse(productItems.isEmpty(), "No search results were found for the term: " + expectedTerm); for empty

        //List<WebElement> productItems = searchPage.listOfProducts();
        List<String> textItems= searchPage.loopThroughItems();
        String expectedTermLower = expectedTerm.toLowerCase();





        // Assert that the product name contains the expected search term.
        /*Assert.assertTrue(textItems.contains(expectedTermLower),
                    "Product name '" + textItems + "' does not contain the expected term '" + expectedTerm + "'.");*/
        for (String productName : textItems) {
            Assert.assertTrue(productName.contains(expectedTermLower),
                    "Product name '" + productName + "' does not contain the expected term '" + expectedTerm + "'.");
        }
        }





    @Then("An error message display that minimum length is 3 characters")
    public void errorMessageDisplay() {
        String expectedText= "Search term minimum length is 3 characters";
        String actualText= searchPage.errorWithResults();

        Assert.assertEquals(actualText,expectedText,"no results found");


    }

    @And("No results is returned")
    public void noResultsIsReturned(String noResults) {
        List<String> textItems= searchPage.loopThroughItems();

        Assert.assertFalse(textItems.isEmpty(), "No search results were found for the term: " + noResults);


    }

    @And("A list is displayed with the related word before click search {string}")
    public void listOFRecommendedProducts(String searchWord) {
        List<String> recommendedItems = searchPage.getRecommendedListTexts();
        //final By searchRecommended = By.cssSelector(".ui-autocomplete li .details");

        System.out.println("🔎 Search word: " + searchWord);
        System.out.println("📋 Recommended items:" + recommendedItems);

        for (String item : recommendedItems) {
            System.out.println(" - " + item);

            Assert.assertTrue(
                    item.contains(searchWord.toLowerCase()),
                    "Expected item to contain: " + searchWord + " but got: " + item
            );


        }
    }

    /*@And("User finds the recommended list in the search results")
    public void listOfProducts() {

    }*/


}
