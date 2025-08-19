package stepsPO;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.Base;
import pages.HomePage;
import pages.ReservePage;

public class ComprarPassagemPO {

    //Atributos - Ponto Final / Estação Final / Terminal
    final WebDriver driver; // Selenium só pode usar e devolver
    // 1 -Declarar
    private HomePage homePage; // Só eu posso usar a Home
    private ReservePage reservePage; // Só eu posso usar a Reserve

    public ComprarPassagemPO(Base base) {
        this.driver = base.driver;
    }

    // As anotações Before e After ficam no Hooks.java
    @Dado("que acesso o site {string} PO")
    public void que_acesso_o_site_po(String url) {
        homePage = new HomePage(driver); // 2 - Instanciar
        homePage.acessarHomePage(url); // 3 - Usar 

    }

    @Quando("seleciono a {string} e {string} PO")
    public void seleciono_a_e_po(String string, String string2) {

    }

    @E("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights_po() {

    }

    @Entao("visualiza a lista de voos PO")
    public void visualiza_a_lista_de_voos_po() {

    }
}
