package com.github.zlwqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/locale.properties"})
public interface WebDriverConfig extends Config {

    @Key("browser")
    String browser();

    @Key("versionBrowser")
    String versionBrowser();

    @Key("browserSize")
    String browserSize();

}
