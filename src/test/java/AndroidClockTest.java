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
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Clock");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("4 Hours 02 Minutes am, Tuesday, 19 October, Off, Double tap to edit.");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.sec.android.app.clockpackage:id/repeat_6");
        el5.click();
        el5.click();


    }
}
