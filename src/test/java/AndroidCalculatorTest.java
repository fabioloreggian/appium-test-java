import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndroidCalculatorTest {
    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String APP_PACKAGE = "APP_PACKAGE";
    public static final String APP_ACTIVITY = "APP_ACTIVITY";
    private AndroidDriver<WebElement> driver;
    private AppiumServer server;

    public static void main(String[] args) {
        AppiumServer s = new AppiumServer();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 'quit' to close the appium server.");
            System.out.print("$ ");

            String input = userInput.nextLine();

            if (input.equals("quit")) {
                s.destroy();
                return;
            }
        }
    }

    @BeforeAll
    public void setUp() throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        String deviceName = p.getProperty(DEVICE_NAME);
        String appPackage = p.getProperty(APP_PACKAGE);
        String appActivity = p.getProperty(APP_ACTIVITY);

        server = new AppiumServer();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9");
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", true);
        driver = new AndroidDriver<>(server.getServiceUrl(), desiredCapabilities);

    }

    @AfterEach()
    public void quitDriver() {
        driver.resetApp();
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
