package stepsPO;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featuresPO",
        glue = "stepsPO",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@"
)
public class Runner {
}
