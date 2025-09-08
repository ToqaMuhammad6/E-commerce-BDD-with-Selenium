package ecommerce.site.hooks;

import ecommerce.site.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp(){
        driver= DriverFactory.initDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
