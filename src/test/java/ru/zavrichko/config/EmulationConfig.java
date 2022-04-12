package ru.zavrichko.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/emulation.properties"})
public interface EmulationConfig extends Config {

    String hubUrl();
    String deviceName();
    String version();
    String platformName();
    String locale();
    String language();
    String appPackage();
    String appActivity();
    String app();
}