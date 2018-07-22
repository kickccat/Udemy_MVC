package io.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.sample")
public class AppConfig {
    
    // Bean methods
    @Bean
    public NumberGenerator numberGenerator(){
        return new NumbergeneratorImpl();
    }
    
    @Bean
    public Game game(){
        return new GameImpl();
    }
    
    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }
}
