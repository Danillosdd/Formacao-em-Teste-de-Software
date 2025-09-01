package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

    protected static WebDriver driver;

    public static void iniciarDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-blink-features=AutomationControlled");
            driver = new ChromeDriver(options);
        }
    }

    public static void fecharDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
