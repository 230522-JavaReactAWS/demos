package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    // All I need to do in here is declare a JMS listener and the queue it should be listening on

    // Let's add in a logger and make things a little more proper
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "sample")
    public void getNameFromQueue(String name){
        logger.info("The name received is " + name);
    }
}
