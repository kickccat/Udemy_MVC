package io.sample.springdemo.service;

import java.util.List;

public interface GenericWelcomeService {
    
    List<String> getWelcomeMessage(String name);
}
