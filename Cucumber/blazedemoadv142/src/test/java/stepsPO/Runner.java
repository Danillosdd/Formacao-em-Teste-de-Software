package stepsPO;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featuresPO"}, // Caminho para suas features
        glue = {"stepsPO"}
)
public class Runner {

}
