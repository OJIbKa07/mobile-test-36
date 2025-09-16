package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${deviceHost}/device.properties"
})
public interface LocalConfig extends Config {
    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();
}
