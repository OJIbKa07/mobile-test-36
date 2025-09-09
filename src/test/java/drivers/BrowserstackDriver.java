package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import config.UserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    private final UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());
    private final MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", userConfig.user());
        caps.setCapability("browserstack.key", userConfig.key());
        caps.setCapability("app", userConfig.appName());
        caps.setCapability("device", mobileConfig.device());
        caps.setCapability("os_version", mobileConfig.osVersion());

        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(new URL(userConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

