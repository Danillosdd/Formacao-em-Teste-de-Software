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
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
u
    @BeforeEach
    public void setUp() {
        var options = new BaseOptions();
        .amend("platformName", "Android");
        .amend("appim:platformVersion", "9.0");
        .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        .amend("appium:deviceOrientation", "portrait");
        .amend("appim:app", "storage:filename=mda-2.2.0-25.apk");
        .amend("appium:appPackage", "com.saucelabs.mydemoapp.android");
        .amend("appium:appActivity", "com.saucelabs.mydemoapp.android.MainActivity");
        .amend("appium:automationName", "UiAutomator2");
        .amend("browserName", "");
        .amend("appim:ensureWebviewsHavePages", true);
        .amend("appium:nativeWebScreenshot", true);
        .amend("appium:newCommandTimeout", 3600);
        .amend("appium:connectHardwareKeyboard", true)



    }
