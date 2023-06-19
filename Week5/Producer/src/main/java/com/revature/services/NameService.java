package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    // I'm going to add in the JMSTemplate which comes from SPRING not JMS and simplifies the interface for interacting
    // with messaging queues
    private final JmsTemplate jmsTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public NameService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendNameToQueue(String name){
        logger.info("Sending " + name + " to the queue!");
        jmsTemplate.convertAndSend("sample", name);
    }
}
