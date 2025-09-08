package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ecommerce.site.steps", "ecommerce.site.hooks"}

)

public class RunnerTest extends AbstractTestNGCucumberTests {

}
