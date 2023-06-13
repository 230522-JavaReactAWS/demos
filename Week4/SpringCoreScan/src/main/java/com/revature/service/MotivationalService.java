package com.revature.service;

import org.springframework.stereotype.Service;

// Mark the class with @Service
@Service("motivationalServiceBean")
public class MotivationalService {

    // We get to do some pretending today
    // We'll pretend that this service makes some call to some motivation api and returns some random motivational
    // statement

    public MotivationalService(){
        // This is not super necessary, just will be useful for later
        System.out.println("Motivational Service Initialized");
    }

    public String fetchMotivationalQuote(){
        // We'll pretend whenever this method is called it makes a call some motivational api

        return "Just Do IT! Yesterday you said tomorrow, so just do it!";
    }
}
