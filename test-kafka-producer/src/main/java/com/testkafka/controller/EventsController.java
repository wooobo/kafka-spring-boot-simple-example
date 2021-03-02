package com.testkafka.controller;

import com.testkafka.domain.Event;
import com.testkafka.producer.EventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    @Autowired
    EventProducer eventProducer;

    @PostMapping("/event")
    public ResponseEntity<Event> postEvent(@RequestBody Event event) throws JsonProcessingException {

//        return ResponseEntity.status(HttpStatus.OK).body(event);
        // send kafka
        eventProducer.sendEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }
}
