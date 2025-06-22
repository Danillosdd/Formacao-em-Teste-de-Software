// Teste automatizado gerado pelo Selenium IDE para o site BlazeDemo
// Simula a compra de uma passagem aérea, preenchendo todos os campos obrigatórios e validando a mensagem final

// 1 - Imports / Dependencias / Apontamento de Bibliotecas
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// 2 - Classe de Teste
public class ComprarPassagemTest {
    // 2.1 - Atributos / Variáveis / Parâmetros  / Características

    private WebDriver driver; // Driver do navegador
    private Map<String, Object> vars; // Variáveis auxiliares
    JavascriptExecutor js; // Executor de JavaScript

    // 2.2 - Funções e Métodos

    // Executa antes de cada teste: inicializa o navegador e variáveis
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    // Executa após cada teste: fecha o navegador
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // Teste principal: simula a compra de uma passagem
    @Test
    public void comprarPassagem() {
        driver.get("https://www.blazedemo.com/index.php"); // Abre o site
        driver.manage().window().setSize(new Dimension(1872, 1048)); // Ajusta o tamanho da janela

        // Seleciona a cidade de origem
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }
        // Seleciona a cidade de destino
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }
        // Realiza algumas ações extras com o dropdown de destino (simulação de interações do usuário)
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        // Clica em elementos da página para avançar no fluxo de compra
        driver.findElement(By.cssSelector(".container:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".container:nth-child(6)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();

        // Preenche o formulário de compra
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Danillo Araújo");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Rua Três Marias");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Goiânia");
        driver.findElement(By.id("state")).sendKeys("Goiás");
        driver.findElement(By.id("zipCode")).sendKeys("74465445");
        driver.findElement(By.id("rememberMe")).click();

        // Finaliza a compra
        driver.findElement(By.cssSelector(".btn-primary")).click();

        // Valida se a mensagem de sucesso está correta
        assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Thank you for your purchase today!");
    }
}
