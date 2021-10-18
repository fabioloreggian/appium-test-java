import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndroidClockTest extends AndroidBaseTest {

    @BeforeAll
    public void init() throws IOException {
        this.properties = "clock.properties";
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
    public void clock() {

        MobileElement el1 = (MobileElement) driver.findElementByXPath("//xk[@content-desc=\"Alarm\"]/android.widget.TextView");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\" Alarm\"])[1]/android.widget.Switch");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"8:30 AM Alarm\"]/android.widget.Switch");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\" Alarm\"]/android.widget.Switch");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"9:00 AM Alarm\"]/android.widget.Switch");
        el5.click();

    }
}
