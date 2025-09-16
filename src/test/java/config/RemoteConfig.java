package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${deviceHost}/${platform}.properties"
})
public interface RemoteConfig extends Config {

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();
}