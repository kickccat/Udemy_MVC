package io.sample.springdemo.domain.promotion;

import io.sample.springdemo.domain.product.ConsumerProduct;
import io.sample.springdemo.domain.product.IndustrialProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myfair")
public class TradeFair {
    
    @Autowired
    private IndustrialProduct industrialProduct;
    
    @Autowired
    private ConsumerProduct consumerProduct;
    
    public TradeFair() {
    }
    
    public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
        this.industrialProduct = industrialProduct;
        this.consumerProduct = consumerProduct;
    }
    
    public void setIndustrialProduct(IndustrialProduct industrialProduct) {
        this.industrialProduct = industrialProduct;
    }
    
    public void setConsumerProduct(ConsumerProduct consumerProduct) {
        this.consumerProduct = consumerProduct;
    }
    
    public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
        return industrialProduct.calculatePrice();
    }
    
    public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
        return consumerProduct.calculatePrice();
    }
    
    public String specialPromotionalPrice() {
        return "Industrial product is priced at $" + declareConsumerProductPrice(consumerProduct) + " and " + "Consumer product is priced at $" + declareIndustrialProductPrice(industrialProduct);
    }
}
