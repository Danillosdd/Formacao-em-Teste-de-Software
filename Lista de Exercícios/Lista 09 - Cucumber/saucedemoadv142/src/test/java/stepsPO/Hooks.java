package stepsPO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.Base;

public class Hooks {

    @Before
    public void setUp() {
        Base.iniciarDriver();
    }

    @After
    public void tearDown() {
        Base.fecharDriver();
    }
}
