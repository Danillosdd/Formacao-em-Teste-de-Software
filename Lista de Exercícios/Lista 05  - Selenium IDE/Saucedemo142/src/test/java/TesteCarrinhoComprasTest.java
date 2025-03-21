// Generated by Selenium IDE

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.HashMap;
import java.util.Map;

public class TesteCarrinhoComprasTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testeCarrinhoCompras() {
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize(); // Maximizar a janela do navegador
        driver.findElement(By.cssSelector("*[data-test=\"login-credentials\"]")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("*[data-test=\"login-credentials\"]"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("*[data-test=\"login-password\"]")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("*[data-test=\"login-password\"]"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".login_wrapper-inner")).click();
        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"item-quantity\"]")).getText(), is("1"));
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), is("Sauce Labs Backpack"));
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), is("$29.99"));
    }
}
