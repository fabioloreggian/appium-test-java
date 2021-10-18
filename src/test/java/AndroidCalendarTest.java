import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.*;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndroidCalendarTest extends AndroidBaseTest {

    @BeforeAll
    public void init() throws IOException {
        this.properties = "calendar.properties";
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

//The following test plays around with some calendar features,
// no data is inputted or edited here just a few button clicks
    @Test
    public void Calendar() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.huawei.calendar:id/day_count_view");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[3]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[4]");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[5]");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"THURSDAY, 16 DECEMBER  Day of Reconciliation   \"]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.huawei.calendar:id/reminders_add_label");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Remove reminder");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‏‏‏‏‎‎‎‎‏‏‎‏‎‎‏‎‏‏‏‏‎‏‎‎‎‏‎‎‏‏‏‎‏‏‎‎‏‏‏‎‏‎‏‏‏‎‏‎‎‏‏‎‎‎‎‎‏‏‎‏‎Navigate up‎‏‎‎‏‎");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[2]");
        el9.click();
    }
}
