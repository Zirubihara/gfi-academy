package com.gfieast.akademia.config;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MainConfiguration {

    Logger myLogger = LoggerFactory.getLogger("myLogger");

    @Value("${custom.string:default}")
    String customStringValue;

    @Value("${custom.long:0}")
    Long customLongValue;

    @PostConstruct
    void setup() {
        log.info("+++++ Custom String value = [{}] +++++", customStringValue);
        log.info("+++++ Custom Long value = [{}] +++++", customLongValue);

        myLogger.debug("+++++ Custom String value = [{}] +++++", customStringValue);
        myLogger.debug("+++++ Custom Long value = [{}] +++++", customLongValue);
    }
}
