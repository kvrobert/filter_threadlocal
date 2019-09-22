package com.robesz.restlogfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Logger {

    public void writeLog(String msg){

        log.info("Log message: " + msg);
    }
}
