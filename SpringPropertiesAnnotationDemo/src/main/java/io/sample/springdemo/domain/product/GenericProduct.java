package io.sample.springdemo.domain.product;

public abstract class GenericProduct {
    
    int priceRandomizer = 1000;
    public abstract int calculatePrice();
}
