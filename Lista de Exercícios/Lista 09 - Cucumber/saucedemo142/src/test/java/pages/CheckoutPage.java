/*
 No Selenium, você pode encontrar elementos usando vários tipos de localizadores. Os principais são:

By.id: Localiza pelo atributo id.
By.name: Localiza pelo atributo name.
By.className: Localiza pela classe CSS.
By.tagName: Localiza pela tag HTML (ex: input, div).
By.linkText: Localiza pelo texto exato de um link (<a>).
By.partialLinkText: Localiza por parte do texto de um link.
By.cssSelector: Localiza usando seletores CSS.
By.xpath: Localiza usando expressões XPath.
Exemplo:

Esses são os principais métodos para localizar elementos no Selenium!
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInformation(String nome, String sobrenome, String cep) {
        driver.findElement(By.id("first-name")).sendKeys(nome);
        driver.findElement(By.id("last-name")).sendKeys(sobrenome);
        driver.findElement(By.id("postal-code")).sendKeys(cep);
        driver.findElement(By.id("continue")).click();
    }

    public boolean isOnOverviewPage() {
        return driver.getCurrentUrl().contains("checkout-step-two.html");
    }

    public void finish() {
        driver.findElement(By.id("finish")).click();
    }
}