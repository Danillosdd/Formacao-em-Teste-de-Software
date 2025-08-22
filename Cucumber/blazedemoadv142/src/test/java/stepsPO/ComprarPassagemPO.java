package stepsPO;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    public String origem;
    public String destino;

    // Construtor
    public ComprarPassagemPO(Base base) {
        this.driver = base.driver;
    }

    // As anotações Before e After ficam no Hooks.java
    @Dado("que acesso o site {string} PO")
    public void que_acesso_o_site_po(String url) {
        homePage = new HomePage(driver); // 2 - Instanciar
        homePage.acessarHomePage(url); // 3 - Usar 

        // Validar se abriu a página correta através do nome da guia    
        assertEquals("BlazeDemo", homePage.lerNomeDaGuia());

    }

    @Quando("seleciono a {string} e {string} PO")
    public void seleciono_a_e_po(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        homePage.selecionarOrigemDesino(origem, destino);

        // Ativar a sincronização para o robô executar devagar
        // E podermos visualizar o funcionamento
        // Importante: É sí como curiosidade ou em caso de problemas
        // O indicado é deixar o robô executar o mais rápido possível
        synchronized (driver) {
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @E("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights_po() {
        homePage.clicarBotaoFindFlights();
        // Chama a Página seguinte --> Reserve
        reservePage = new ReservePage(driver); // Instanciar ReservePage

    }

    @Entao("visualiza a lista de voos PO")
    public void visualiza_a_lista_de_voos_po() {
        assertEquals("BlazeDemo - reserve", reservePage.lerNomeDaGuia());
        assertEquals("Flights from " + this.origem + " to " + this.destino + ":", reservePage.lerCabecalhoVoos());
    }

}
