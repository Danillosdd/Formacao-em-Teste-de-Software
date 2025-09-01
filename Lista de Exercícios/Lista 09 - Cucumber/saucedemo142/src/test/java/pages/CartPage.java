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

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) {
        String xpath = String.format("//div[@class='cart_item']//div[text()='%s']", productName);
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public void checkout() {
        driver.findElement(By.id("checkout")).click();
    }
}