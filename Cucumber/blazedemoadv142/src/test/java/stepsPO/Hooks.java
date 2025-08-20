package stepsPO;

import io.cucumber.java.Before;
import pages.Base;

public class Hooks {

    Base base;

    // Construtor
    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void iniciarPO() {
        WebDriverManager.chromedriver().setup();
    }

}
