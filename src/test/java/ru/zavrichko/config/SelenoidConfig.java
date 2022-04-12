package ru.zavrichko.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/selenoid.properties"})
public interface SelenoidConfig extends Config {

    String hubUrl();
    String user();
    String password();
    String videoUrl();
    String deviceName();
    String version();
    String platformName();
    String locale();
    String language();
    String appPackage();
    String appActivity();
    String app();
}
