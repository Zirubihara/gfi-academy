package com.gfieast.akademia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NoteService {

    public NoteService() {
        log.info("===== Spring create instance of this class: {}", NoteService.class);
    }

    public String getName() {
        return "NAME FROM NOTE";
    }
}
