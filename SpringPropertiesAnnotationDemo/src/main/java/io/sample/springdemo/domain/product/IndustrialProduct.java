package io.sample.springdemo.domain.product;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IndustrialProduct extends GenericProduct {
    @Override
    public int calculatePrice() {
        Random random = new Random();
    
        return random.nextInt(priceRandomizer);
    }
}