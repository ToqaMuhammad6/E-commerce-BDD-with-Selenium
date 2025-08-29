package ecommerce.site.base;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }


    public void navigate(String url){
        driver.navigate().to(url);
    }


}
