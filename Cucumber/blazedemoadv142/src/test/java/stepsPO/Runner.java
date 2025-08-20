package stepsPO;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featuresPO"}, // Caminho para suas features
        glue = {"stepsPO"}, // Caminho para automação
        dryRun = false, // Configuração do Log
        monochrome = true // Detalhes do Log
)

public class Runner {

}
