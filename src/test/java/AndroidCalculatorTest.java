import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndroidCalculatorTest extends AndroidBaseTest {

    @BeforeAll
    public void init() throws IOException {
        this.properties = "calculator.properties";
        super.setUp();

    }

    @AfterEach()
    public void onDestroyEach() {
        super.quitDriver();
    }

    @AfterAll
    public void onDestroy() {
        super.destroy();
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
