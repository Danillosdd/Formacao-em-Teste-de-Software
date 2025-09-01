package pages;

import org.openqa.selenium.WebDriver;

public class CommonPage extends Base {

    protected WebDriver driver;

    public CommonPage() {
        this.driver = Base.getDriver();
    }

    public String getUrlAtual() {
        return driver.getCurrentUrl();
    }

    public String getTituloPagina() {
        return driver.getTitle();
    }
}
