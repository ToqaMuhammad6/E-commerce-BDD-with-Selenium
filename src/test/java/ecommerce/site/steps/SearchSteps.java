package ecommerce.site.steps;

import ecommerce.site.factory.DriverFactory;
import ecommerce.site.pages.RegistrationPage;
import ecommerce.site.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class SearchSteps {

    WebDriver driver;
    RegistrationPage registrationPage;
    SearchPage searchPage;

    /*@Given("SUser opens the site \"(.*)\"$")
    public void openTheSiteForLogin(String url) {
        driver = DriverFactory.initDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigate(url);
    }*/

    @When("User enters a word for search {string}")
    public void searchForAProduct(String searchWord) {
        driver = DriverFactory.getDriver();
        searchPage = new SearchPage(driver);
        searchPage.searchFor(searchWord);
    }

    @And("User clicks on the search button")
    public void clickOnTheSearchBtn() {
        searchPage.searchButton();
    }



    @Then("User finds the results contain the same word of the search {string}")
    public void resultsOFTheSearch(String expectedTerm) {
        /* resultContainer = searchPage.keyWord();

        Assert.assertTrue(resultContainer.isDisplayed());

        Assert.assertTrue(driver.getTitle().contains(expectedTerm));
        System.out.println(expectedTerm);*/

         // Adjust locator
        //Assert.assertTrue(resultsContainer.isDisplayed());
        //Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTerm.toLowerCase()));
        //WebElement productName = firstResult.findElement(By.cssSelector("img[alt='Picture of Samsung Premium Ultrabook']")); //worked
        // Assert.assertTrue(productName.getText().toLowerCase().contains(expectedTerm.toLowerCase()));

        //Assert.assertFalse(productItems.isEmpty(), "No search results were found for the term: " + expectedTerm); for empty

        //List<WebElement> productItems = searchPage.listOfProducts();
        List<String> textItems= searchPage.loopThroughItems();



        /*Assert.assertTrue(textItems.contains(expectedTermLower),
                    "Product name '" + textItems + "' does not contain the expected term '" + expectedTerm + "'.");*/
        for (String productName : textItems) {
            Assert.assertTrue(productName.toLowerCase().contains(expectedTerm.toLowerCase()),
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
    public void noResultsIsReturned() {
        List<String> textItems= searchPage.loopThroughItems();

        Assert.assertTrue(textItems.isEmpty(), "No search results were found for the term: ");


    }

    @Then("A list is displayed with the related word before click search {string}")
    public void listOFRecommendedProducts(String searchWord) {
        List<String> recommendedItems = searchPage.getRecommendedListTexts();
        //final By searchRecommended = By.cssSelector(".ui-autocomplete li .details");

        System.out.println("Search word: " + searchWord);
        System.out.println("Recommended items:" + recommendedItems);

        for (String item : recommendedItems) {
            Assert.assertTrue(
                    item.toLowerCase().contains(searchWord.toLowerCase()),
                    "Expected item to contain: " + searchWord + " but got: " + item
            );


        }
    }



}
