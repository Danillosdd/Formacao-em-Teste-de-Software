// This sample code supports Appium Java client >= 9
// https://github.com/appium/java-client

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.Selenium.*;

public class ConsultarProeutoTest {

    private AndroidDriver driver;

    private URL pegarUrl() {
        try {
            return new URL("https://InstrutorIterasys27:");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        var options = new BaseOptions();
        .amend("platformName", "Android");
        .amend("appim:platformVersion", "9.0");
        .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        .amend("appium:deviceOrientation", "portrait");

    }
