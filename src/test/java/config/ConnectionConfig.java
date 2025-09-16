package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${deviceHost}/connection.properties"
})
public interface ConnectionConfig extends Config {
    @Key("remoteUrl")
    String remoteUrl();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}
