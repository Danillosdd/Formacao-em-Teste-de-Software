// 1 - Bibliotecas / Imports

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 2 - Classe 
public class LoginTest {

    // 2.1 - Atributos
    private WebDriver driver; // Objeto do Selenium WebDriver

    // 2.2 - Funções(Tem Retorno) e Métodos(Não tem retorno)
    // Antes de cada Teste
    @BeforeEach
    public void iniciar() {
        driver = new ChromeDriver(); // Instanciar o ChromeDriver (Instanciar o objeto do Selenium como ChromeDriver)
        driver.get("https://the-internet.herokuapp.com/login"); // Acessar o site
        //driver.manage().window().maximize(); // Maximizar a janela do navegador
    }

    // Depois de cada Teste
    @AfterEach
    public void finalizar() {
        driver.quit(); // Fechar o navegador (Destruir o objeto do Selenium)
    }

    // Métodos auxiliares
    public void usernameSucesso() {
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    public void usernameFalha() {
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith-old");
    }

    public void passwordSucesso() {
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    }

    public void passwordFalha() {
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!-old");
    }

    public void botaoLogin() {
        // Clica no botão de login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    //Testes
    @Test // username(sucesso) | password(sucesso)
    public void loginSucesso() {
        usernameSucesso();
        passwordSucesso();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("You logged into a secure area!"));
    }

    @Test //  1 username(sucesso) | password(falha)
    public void loginPasswordFalha() {
        usernameSucesso();
        passwordFalha();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your password is invalid!"));
    }

    @Test //  2 username(sucesso) | password(branco)
    public void loginPasswordBranco() {
        usernameSucesso();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your password is invalid!"));
    }

    @Test //  3  username(falha) | password(falha)
    public void loginUsernameFalhaPasswordFalha() {
        usernameFalha();
        passwordFalha();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your username is invalid!"));
    }

    @Test //  4  username(falha) | password(sucesso)
    public void loginUsernameFalha() {
        usernameFalha();
        passwordSucesso();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your username is invalid!"));
    }

    @Test //  5  username(falha) | password(branco)
    public void loginUsernameFalhaPasswordBranco() {
        usernameFalha();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your username is invalid!"));
    }

    @Test //  6  username(branco) | password(branco)
    public void loginUsernameBrancoPasswordBranco() {
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your username is invalid!"));
    }

    @Test //  7  username(branco) | password(falha)
    public void loginUsernameBrancoPasswordFalha() {
        passwordFalha();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your username is invalid!"));
    }

    @Test //  8  username(branco) | password(sucesso)
    public void loginUsernameBrancoPasswordSucesso() {
        passwordSucesso();
        botaoLogin();
        // Verifica se foi realizado o login com sucesso!
        String mensagem = driver.findElement(By.id("flash")).getText().trim();
        assertTrue(mensagem.contains("Your username is invalid!"));
    }

    /*----------------------------------------------------------
    By.id(String id): Localiza um elemento pelo atributo id.
    By.name(String name): Localiza um elemento pelo atributo name.
    By.className(String className): Localiza um elemento pelo atributo class.
    By.tagName(String tagName): Localiza um elemento pelo nome da tag HTML.
    By.cssSelector(String cssSelector): Localiza um elemento usando um seletor CSS.
    By.xpath(String xpathExpression): Localiza um elemento usando uma expressão XPath.
    By.linkText(String linkText): Localiza um link (elemento <a>) pelo texto do link.
    By.partialLinkText(String partialLinkText): Localiza um link (elemento <a>) pelo texto parcial do link.
     */


    
    
} // Final da Classe LoginTest
