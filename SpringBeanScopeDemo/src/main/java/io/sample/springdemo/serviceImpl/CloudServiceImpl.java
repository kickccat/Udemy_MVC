package io.sample.springdemo.serviceImpl;

import io.sample.springdemo.service.BusinessService;

import java.util.Random;

public class CloudServiceImpl implements BusinessService {
    
    public String offerService(String companyName) {
        Random random = new Random();
        
        return "\nAs an Organization, " + companyName +
                         " offers world class Cloud computing infrastructure." +
                         "\nThe annual income exceeds " + random.nextInt(revenue) + " dollars.";
    }
}
