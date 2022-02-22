package com.github.zlwqa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:/tmp/stands.properties",
        "classpath:config/stands.properties"
})
public interface AppConfig extends Config {

    String mainPageYourselfURL();

    String mainPageForBusinessURL();
}
