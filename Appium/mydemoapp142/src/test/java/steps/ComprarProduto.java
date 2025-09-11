package steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ComprarProduto {

    private AndroidDriver driver;

    private URL getUrl() {
        try {
            return new URL("https://danillo.sdd:d16f7bb2-9729-4aa5-ae9a-4bc95891689f@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Before
    public void iniciar() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:platformVersion", "9.0")
                .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
                .amend("appium:deviceOrientation", "portrait")
                .amend("appium:app", "storage:filename=mda-2.2.0-25.apk")
                .amend("appium:appPackage", "com.saucelabs.mydemoapp.android")
                .amend("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
                .amend("appium:automationName", "UiAutomator2")
                .amend("browserName", "")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("sauce:options", Map.ofEntries(Map.entry("name", "Appium Desktop Session -- Sep 9, 2025 9:55 PM")))
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("webSocketUrl", true)
                .amend("unhandledPromptBehavior", "ignore");
        driver = new AndroidDriver(this.getUrl(), options);
    }

    @After
    public void finalizar() {
        driver.quit();
    }

    @Dado("que acesso o My Demo App")
    public void que_acesso_o_my_demo_app() {
        // O app foi aberto no final do método iniciar (Before)
    }

    @E("verifico o logo e nome da secao")
    public void verifico_o_logo_e_nome_da_secao() {
        var imgLogo = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/mTvTitle"));
        assertEquals(imgLogo.isDisplayed(), true);

        var lblTituloSecao = driver.findElement(AppiumBy.id(""));
        assertEquals("Products", lblTituloSecao.getText());
    }

    @E("localizo o {string} que esta por {string}")
    public void localizo_o_que_esta_por(String produto, String preco) {
        // Home
        // produto :
        // preco   :
        assertEquals(produto, driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Product title\" and @text=" + produto + "]")).getText());
        assertEquals(preco, driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Product Price\"])[1]")).getText());
    }

    @Quando("clico na imagem do {int}")
    public void clico_na_imagem_do(Integer num_produto) {

    }

    @Entao("na tela do produto verifico o {string} e o {string}")
    public void na_tela_do_produto_verifico_o_e_o(String produto, String preco) {

    }

    @Quando("arrasto para cima e clico no botao Add Cart")
    public void arrasto_para_cima_e_clico_no_botao_add_cart() {
        // Tela do Produto
        // botao adicionar no carrinho :
    }

    @Entao("na tela do carrinho verifico o {string} {string} e {int}")
    public void na_tela_do_carrinho_verifico_o_e(String produto, String preco, Integer quantidade) {
        // Carrinho
        // produto    :
        // preco      :
        // quantidade :
    }
}
