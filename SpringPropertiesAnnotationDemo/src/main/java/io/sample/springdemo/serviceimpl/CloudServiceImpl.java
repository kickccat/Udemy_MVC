package io.sample.springdemo.serviceimpl;

import io.sample.springdemo.service.BusinessService;

import java.util.Random;

public class CloudServiceImpl implements BusinessService {
    @Override
    public String offerService(String companyName) {
        Random random = new Random();
        return "\nAs an Organization, " + companyName + " offers world class Cloud computing infrastructure." + "\nThe annual revenue exceeds " + random.nextInt(revenue) + " dollars.";
    }
    
    public void postConstruct() {
        System.out.println("CloudService: postConstruct called......");
    }
    
    public void preDestroy() {
        System.out.println("CloudSevice: preDestroy called.......");
    }
}
