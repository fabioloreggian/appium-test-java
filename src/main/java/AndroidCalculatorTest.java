import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndroidCalculatorTest {
    private AndroidDriver<WebElement> driver;
    private AppiumServer server;

    @BeforeAll
    public void setUp() {
        server = new AppiumServer();
    }

    @BeforeEach
    public void resetApp() throws MalformedURLException {
        String deviceName = "ce0917199b18d8fd0d";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9");
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", true);

        driver = new AndroidDriver<>(server.getServiceUrl(), desiredCapabilities);
    }

    @AfterEach()
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public void destroy() {
        server.destroy();
    }

    @Test
    public void sixtyNine() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
        el1.click();
        el1.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("minus");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();
    }

    @Test
    public void sin() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("sine");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_6");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("right parenthesis");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();
    }
}
