import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    private static AppiumDriverLocalService service;

    public void setup() throws IOException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    public void destroy() {
        if (service != null) {
            service.stop();
        }
    }

    public URL getServiceUrl() throws MalformedURLException {
        return new URL("http://127.0.0.1:4723/wd/hub");
        //return service.getUrl();
    }

}
