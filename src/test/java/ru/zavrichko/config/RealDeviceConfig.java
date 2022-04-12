package ru.zavrichko.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/realdevice.properties"})
public interface RealDeviceConfig extends Config {

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
