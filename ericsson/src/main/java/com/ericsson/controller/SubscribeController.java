package com.ericsson.controller;

import com.ericsson.constant.Constants;
import com.ericsson.exception.RecordNotFoundException;
import com.ericsson.model.Subscribe;
import com.ericsson.service.SubscribeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SubscribeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeController.class);

    @Autowired
    private SubscribeService subscribeService;

    @PostMapping("/subscriber")
    public void addSubscribe(@RequestBody Subscribe subscribe, HttpServletRequest request) {
        subscribeService.add(subscribe);
        logForSubcribe(request, subscribe.toString());
    }

    @PutMapping("/subscriber")
    public ResponseEntity<Subscribe> updateSubscribe(@RequestBody Subscribe currSubscribe, HttpServletRequest request) {
        Subscribe subscribe = subscribeService.findById(currSubscribe.getId());
        logForSubcribe(request, currSubscribe.toString());

        if (subscribe == null) {
            throw new RecordNotFoundException(Constants.SUBSCRIBE_NOTFOUND_MESSAGE + subscribe.getId());
        }

        subscribeService.update(currSubscribe);
        return new ResponseEntity<>(currSubscribe, HttpStatus.OK);
    }

    @DeleteMapping("/subscriber")
    public ResponseEntity<Subscribe> deleteSubscribe(@RequestBody Subscribe currSubcribe, HttpServletRequest request) {
        Subscribe subscribe = subscribeService.findById(currSubcribe.getId());
        logForSubcribe(request, currSubcribe.getId());

        if (subscribe == null) {
            throw new RecordNotFoundException(Constants.SUBSCRIBE_NOTFOUND_MESSAGE + currSubcribe.getId());
        }

        subscribeService.delete(subscribe.getId());

        return new ResponseEntity<>(subscribe, HttpStatus.OK);
    }

    @GetMapping("/getAllSubscribers")
    public List<Subscribe> getAllSubscribers(HttpServletRequest request) {
        logForSubcribe(request, "");
        return subscribeService.getAll();
    }


    private void logForSubcribe(HttpServletRequest request, String message) {
        LOGGER.info(request.getRequestURI() + "[" + request.getMethod() + "] " + message);
    }

}
