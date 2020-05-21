package com.gfieast.akademia.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class JustLog {

    @PostConstruct
    void setup() {
        log.trace("This log should be visible only in log file");
    }
}
