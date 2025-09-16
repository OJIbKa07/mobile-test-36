package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${deviceHost}/user.properties"
})
public interface UserConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("appName")
    String appName();
}