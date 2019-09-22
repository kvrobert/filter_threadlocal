package com.robesz.restlogfilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.applet.AppletContext;

@RestController
@RequestMapping(value = "/rest")
public class Controller {

    private final Logger logger;

    public Controller(Logger logger) {
        this.logger = logger;
    }

    @PostMapping(value = "/first")
    public String first(@RequestBody String text){
        logger.writeLog("Rest, first..." + text + "_UUID:" + LocalThreadUUID.getUuid());
        return text;
    }

    @PostMapping(value = "/second")
    public String second(@RequestBody String text){
        logger.writeLog("Rest, second..." + text + "_UUID:" + LocalThreadUUID.getUuid());
        return text;
    }
}
