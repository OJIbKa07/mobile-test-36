package drivers;

import com.codeborne.selenide.WebDriverProvider;

public class DriverFactory {

    public static WebDriverProvider getDriver() {
        String deviceHost = System.getProperty("deviceHost", "local");

        switch (deviceHost) {
            case "local":
                return new LocalDriver();
            case "remote":
                return new BrowserstackDriver();
            default:
                throw new RuntimeException("Unknown deviceHost: " + deviceHost);
        }
    }
}
