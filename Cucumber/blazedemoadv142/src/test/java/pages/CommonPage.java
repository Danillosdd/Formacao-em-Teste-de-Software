package pages;

import org.openqa.selenium.WebDriver;

public class CommonPage {

    public WebDriver driver; // bola quando ele recebe o passe

    // Método construtor - Conecta o exterior com o interior da classe
    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    // ToDo: Vamos colocar funçẽs em comum nas páginas aqui
}