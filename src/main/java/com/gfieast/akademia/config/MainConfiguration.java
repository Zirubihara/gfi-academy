package com.gfieast.akademia.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static java.lang.String.format;

@Configuration
public class MainConfiguration {

    @Value("${custom.string:default}")
    String customStringValue;

    @Value("${custom.long:0}")
    Long customLongValue;

    @PostConstruct
    void setup() {
        System.out.println(format("+++++ Custom String value = [%s] +++++", customStringValue));
        System.out.println(format("+++++ Custom Long value = [%s] +++++", customLongValue));
    }
}
