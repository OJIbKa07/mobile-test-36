package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.RemoteConfig;
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
    private final RemoteConfig remoteConfig = ConfigFactory.create(RemoteConfig.class, System.getProperties());
    private final UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserstack.user", userConfig.user());
        caps.setCapability("browserstack.key", userConfig.key());
        caps.setCapability("app", userConfig.appName());
        caps.setCapability("device", remoteConfig.device());
        caps.setCapability("os_version", remoteConfig.osVersion());

        try {
            return new RemoteWebDriver(new URL(userConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

