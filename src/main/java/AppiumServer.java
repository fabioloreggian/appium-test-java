import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumServer {
    private final AppiumDriverLocalService server;

    public AppiumServer() {
        server = AppiumDriverLocalService.buildDefaultService();
        server.start();
    }

    public void destroy() {
        if (server != null) {
            server.stop();
        }
    }

    public URL getServiceUrl() throws MalformedURLException {
        return server.getUrl();
    }
}
