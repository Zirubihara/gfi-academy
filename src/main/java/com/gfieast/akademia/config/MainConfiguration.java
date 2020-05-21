package com.gfieast.akademia.config;

import com.gfieast.akademia.service.NoteService;
import com.gfieast.akademia.service.OtherService;
import com.gfieast.akademia.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MainConfiguration {

    @Bean
    UserService userService(NoteService noteService) {
        return new UserService(noteService);
    }

    @Bean(name="otherService2")
    OtherService otherService(NoteService noteService, UserService userService) {
        return new OtherService(noteService, userService);
    }

//    @Bean
//    OtherService otherService2(NoteService noteService, UserService userService) {
//        return new OtherService(noteService, userService);
//    }
}
