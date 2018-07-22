package io.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageGeneratorImpl implements MessageGenerator {
    
    // Constant
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    
    @Autowired
    private Game game;
    
    private int guessCount = 10;
    
    // Init
    public void init(){
        log.info("game = {}", game);
    }
    
    @Override
    public String getMainMessage() {
        return "getMainMessage() called";
    }
    
    @Override
    public String getResultMessage() {
        return "getResultMessage() called";
    }
}
