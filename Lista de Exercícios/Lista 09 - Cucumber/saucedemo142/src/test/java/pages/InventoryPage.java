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

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button", productName);
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean isProductAdded(String productName) {
        // Verifica se o botão mudou para "Remove"
        String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']", productName);
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
