package com.ericsson.schedular;

import com.ericsson.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Scheduler {
    @Autowired
    SubscribeService subscribeService;

    @Scheduled(cron = "${schedular}")
    public void writeDataToFile() {
        subscribeService.writeToFile();
    }
}
