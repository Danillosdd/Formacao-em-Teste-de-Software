package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class ComprarPassagemBDD {

    @Dado("que acesso o site: {string}")
    public void que_acesso_o_site(String String) {
    }

    @Quando("seleciono a origem {string} e o destino {string}")
    public void seleciono_a_origem_e_o_destino(String origem, String destino) {
    }

    @E("clico no botão Find Flights")
    public void clico_no_botão_Find_Flights() {
    }

    @Entao("visualiza a lista de voos")
    public void visualiza_a_lista_de_voos() {
    }

}