package com.gfieast.akademia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyNoteApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder
                .sources(MyNoteApp.class)
                .properties("spring.config.name:application,note-app");
    }

    public static void main(String[] args) {
        SpringApplication.run(MyNoteApp.class, args);
    }
}
