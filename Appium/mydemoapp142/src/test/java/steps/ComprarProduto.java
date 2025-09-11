package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ComprarProduto {

    @Dado("que acesso o My Demo App")
    public void que_acesso_o_my_demo_app() {
    }

    @E("verifico o logo e nome da secao")
    public void verifico_o_logo_e_nome_da_secao() {
    }

    @E("localizo o <produto> que esta por <preco>")
    public void localizo_o_produto_que_esta_por_preco(String produto, String preco) {
    }

    @Quando("clico na imagem do <numProduto>")
    public void clico_na_imagem_do_num_produto(int numProduto) {
    }

    @Entao("na tela do produto verifico o <produto> e o <preco>")
    public void verifico_produto_preco_na_tela_do_produto(String produto, String preco) {
    }

    @Quando("arrasto para cima e clico no botao Add Cart")
    public void arrasto_para_cima_e_clico_no_botao_add_cart() {
    }

    @Entao("na tela do carrinho verifico o <produto> <preco> e <quantidade>")
    public void na_tela_do_carrinho_verifico_o_produto_preco_e_quantidade(String produto, String preco, String quantidade) {
    }
}
