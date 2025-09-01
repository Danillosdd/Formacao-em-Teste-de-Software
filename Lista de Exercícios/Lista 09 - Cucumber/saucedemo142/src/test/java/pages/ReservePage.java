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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage extends CommonPage {

    // construtor
    public ReservePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Mapeamento de elementos
    @FindBy(css = "h3")
    private WebElement flightsHeader; // Cabeçalho dos vôos

    public By byOrder(int ordem_do_voo) {
        return By.xpath("//table[@class='table']/tbody/tr[" + ordem_do_voo + "]//input[@type='submit']");
    }

    // ações
    public String lerCabecalhoVoos() {
        return flightsHeader.getText();
    }

    public void clicarNoVoo(int ordem_do_voo) {
        driver.findElement(byOrder(ordem_do_voo)).click();
    }

}
