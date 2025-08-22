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

public class HomePage extends CommonPage {

    // Método Construtor
    public HomePage(WebDriver driver) {
        super(driver); // Driver herdado de CommonPage - Super Classe
        PageFactory.initElements(driver, this);
    }

    // Elementos Mapeados
    // Mapeamento para os combos Origem e Destino
    public By byLocal(String local) {
        return By.cssSelector("option[value=\"" + local + "\"]"); // Toda vez que tem um \" a " vai ser ignorada na 1º
        // vez, mas a " vai ser usada na 2º vez, fica assim na
        // execução: option[value="Rome"]
    }

    //@FindBy(css = "input.btn.btn-primary")
    //@FindBy(css = "input[value]")
    @FindBy(css = ".btn-primary")
    WebElement btnFindFlights;

    // Ações com Elementos Mapeados
    public void selecionarOrigemDesino(String byOrigem, String byDestino) {
        driver.findElement(byLocal(byOrigem)).click(); // Seleciona a Origem
        driver.findElement(byLocal(byDestino)).click(); // Seleciona o Destino
    }

    public void clicarBotaoFindFlights() {
        btnFindFlights.click();
    }

    public void acessarHomePage(String url) {
        driver.get(url); // Acessa a Home Page
    }

}
