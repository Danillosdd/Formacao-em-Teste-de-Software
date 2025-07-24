package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ComprarPassagemBDD {

    WebDriver driver; // objeto do Selenium WebDriver

    @Before
    public void iniciar() {
        WebDriverManager.chromedriver().setup(); // configura o WebDriver para o Chrome
        driver = new ChromeDriver(); // instancia como ChromeDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); // espera implícita de 3 segundos
    }

    @After
    public void finalizar() {

    }

    @Dado("que acesso o site: {string}")
    public void que_acesso_o_site(String String) {
    }

    @Quando("seleciono a origem {string} e o destino {string}")
    public void seleciono_a_origem_e_o_destino(String origem, String destino) {
    }

    @E("clico no botão Find Flights")
    public void clico_no_botão_Find_Flights() {
    }

    @Entao("visualiza a lista de voos")
    public void visualiza_a_lista_de_voos() {
    }

}