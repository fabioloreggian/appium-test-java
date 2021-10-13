import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndroidBasicInteractionsTest extends BaseTest {
    private AndroidDriver<WebElement> driver;

    @BeforeAll
    public void setUp() throws IOException {
        super.setup();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9");
        desiredCapabilities.setCapability("deviceName", "ce0917199b18d8fd0d");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", true);

        driver = new AndroidDriver<WebElement>(getServiceUrl(), desiredCapabilities);
    }

    @AfterAll
    public void destroy() {
        if (driver != null) {
            driver.quit();
        }
        super.destroy();
    }


    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
        el1.click();
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("minus");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();
    }
}
