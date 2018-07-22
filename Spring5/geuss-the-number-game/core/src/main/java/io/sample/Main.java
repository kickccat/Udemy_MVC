package io.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static final String CONFIG_LOCATION = "beans.xml";
    
    public static void main(String[] args) {
        logger.info("Guess The Number Game");
        
        // Create context (container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        
        // Call method next()
        int number = numberGenerator.next();
        logger.info("number = {}", number);
        
        // Get game bean from context (container)
        Game game = context.getBean(Game.class);
        
        context.close();
    }
}
