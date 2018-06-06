package io.sample.springdemo.serviceimpl;

import io.sample.springdemo.service.BusinessService;

import java.util.Random;

public class EcommerceServiceImpl implements BusinessService {
    @Override
    public String offerService(String companyName) {
        Random random = new Random();
        return "\nAs an Organization, " + companyName + " provides an outstanding Ecommerce platform." + "\nThe annual revenue exceeds " + random.nextInt(revenue) + " dollars.";
    }
}
