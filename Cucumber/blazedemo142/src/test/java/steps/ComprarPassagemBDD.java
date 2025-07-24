package steps;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    String origem;
    String destino;

    @Before
    public void iniciar() {
        WebDriverManager.chromedriver().setup(); // configura o WebDriver para o Chrome
        driver = new ChromeDriver(); // instancia como ChromeDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); // espera implícita de 3 segundos
        driver.manage().window().maximize(); // maximiza a janela do navegador
    }

    @After
    public void finalizar() {
        driver.quit(); // destruir o objeto do WebDriver
    }

    @Dado("que acesso o site: {string}")
    public void que_acesso_o_site(String url) {
        driver.get(url);
    }

    @Quando("seleciono a origem {string} e o destino {string}")
    public void seleciono_a_origem_e_destino(String origem, String destino) {
        {
            this.origem = origem;
            WebElement combo = driver.findElement(By.name("fromPort"));
            combo.click();
            combo.findElement(By.xpath("//option[. = '" + origem + "']")).click();
        }
        {
            this.destino = destino;
            WebElement combo = driver.findElement(By.name("toPort"));
            combo.click();
            combo.findElement(By.xpath("//option[. = '" + destino + "']")).click();
        }
    }

    @E("clico no botão Find Flights")
    public void clico_no_botão_Find_Flights() {
        driver.findElement(By.cssSelector(".btn.btn-primary")).click(); // clica no botão "Find Flights"
    }

    @Entao("visualiza a lista de voos")
    public void visualiza_a_lista_de_voos() {
        assertEquals("Flights from " + origem + " to " + destino,
                driver.findElement(By.cssSelector("h3")).getText());
    }

}