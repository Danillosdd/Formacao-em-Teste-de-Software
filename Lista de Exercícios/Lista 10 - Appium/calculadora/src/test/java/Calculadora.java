//mvn clean test

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

public class Calculadora {

    private AndroidDriver driver;

    private URL getUrl() {
        try {
            return new URL(
                    "https://oauth-danillo.sdd-1bce0:d8f4796c-46db-49a1-937f-d3547dab1442@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @BeforeEach
    public void setUp() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:platformVersion", "9.0")
                .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
                .amend("appium:deviceOrientation", "portrait")
                .amend("appium:app", "storage:filename=Calculator_8.6.1 (625857114)_APKPure.apk")
                .amend("appium:appPackage", "com.google.android.calculator")
                .amend("appium:appActivity", "com.google.android.gms.common.api.GoogleApiActivity")
                .amend("appium:automationName", "UiAutomator2")
                .amend("browserName", "")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("sauce:options", Map.ofEntries(Map.entry("name", "Appium Desktop Session -- Vscode")))
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("unhandledPromptBehavior", "ignore");

        driver = new AndroidDriver(this.getUrl(), options);
    }

    /*
     * @Test
     * public void sampleTest() {
     * var imgMochila = driver.findElement(AppiumBy.
     * xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]"));
     * imgMochila.click();
     * var lblTituloProduto =
     * driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV"
     * ));
     * assertEquals("Sauce Labs Backpack", lblTituloProduto.getText());
     * var lblPrecoProduto =
     * driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV"))
     * ;
     * assertEquals("$ 29.99", lblPrecoProduto.getText());
     */
    @Test
    public void testeCalculadoraSoma() throws InterruptedException {
        // Aguarda a calculadora carregar
        Thread.sleep(3000);

        // Realiza a operação 2 + 3 = 5
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();

        // Verifica o resultado
        var resultado = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result"));
        assertEquals("5", resultado.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
