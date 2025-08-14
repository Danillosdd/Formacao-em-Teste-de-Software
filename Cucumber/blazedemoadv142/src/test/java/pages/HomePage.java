package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonPage {

    // Método Construtor
    public HomePage(WebDriver driver) {
        super(driver); // Driver herdado de CommonPage - Super Classe
        PageFactory.initElements(driver, this);
    }

    // Elementos Mapeados
    // Mapeamento para os combos Origem e Destino
    public By bylocal(String local){
        return By.cssSelector("option[value=\"" + local + "\"]"); // Toda vez que tem um \" a " vai ser ignorada na 1º vez, mas a " vai ser usada na 2º vez, fica assim na execução: option[value="Rome"]
    }

    // Ações com Elementos Mapeados
}
