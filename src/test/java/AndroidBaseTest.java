import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

public class AndroidBaseTest {
    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String APP_PACKAGE = "APP_PACKAGE";
    public static final String APP_ACTIVITY = "APP_ACTIVITY";
    public static final String PLATFORM_VERSION = "PLATFORM_VERSION";
    public static final String SYSTEM_PROPERTIES = "config.properties";
    public String properties;
    protected AndroidDriver<WebElement> driver;
    protected AppiumServer server;

    public void setUp() throws IOException {
        assert (properties != null);
        Properties systemProperties = new Properties();
        systemProperties.load(ClassLoader.getSystemResourceAsStream(SYSTEM_PROPERTIES));
        String deviceName = systemProperties.getProperty(DEVICE_NAME);
        String platformVersion = systemProperties.getProperty(PLATFORM_VERSION);

        Properties applicationProperties = new Properties();
        applicationProperties.load(ClassLoader.getSystemResourceAsStream(properties));
        String appPackage = applicationProperties.getProperty(APP_PACKAGE);
        String appActivity = applicationProperties.getProperty(APP_ACTIVITY);

        server = new AppiumServer();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", true);
        driver = new AndroidDriver<>(server.getServiceUrl(), desiredCapabilities);

    }

    public void quitDriver() {
        driver.resetApp();
    }

    public void destroy() {
        server.destroy();
    }
}
