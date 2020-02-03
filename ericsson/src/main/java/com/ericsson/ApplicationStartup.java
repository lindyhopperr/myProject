package com.ericsson;

import com.ericsson.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private SubscribeService subscribeService;
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        subscribeService.readFromFile();
    }
}