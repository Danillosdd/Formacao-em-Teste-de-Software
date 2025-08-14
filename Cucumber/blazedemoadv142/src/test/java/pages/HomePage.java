package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonPage {

    // Método Construtor
    public HomePage(WebDriver driver) {
        super(driver); // Driver herdado de CommonPage - Super Classe
        PageFactory.initElements(driver, this);
    }

}
