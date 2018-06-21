package io.sample.springdemo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WelcomeService implements GenericWelcomeService {
    
    private String name;
    
    public List<String> getWelcomeMessage(String name) {
        List<String> myWelcomeMessage = new ArrayList<String>();
        
        myWelcomeMessage.add("Hello " + name);
        myWelcomeMessage.add(", Welcome to the spring course...");
        
        return myWelcomeMessage;
    }
}
