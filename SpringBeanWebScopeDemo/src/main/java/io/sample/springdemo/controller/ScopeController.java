package io.sample.springdemo.controller;

import io.sample.springdemo.service.RandomizerRequestScope;
import io.sample.springdemo.service.RandomizerSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ScopeController {
    
    @Autowired
    RandomizerRequestScope requestScope;
    
    @Autowired
    RandomizerSessionScope sessionScope;
    
    @RequestMapping("/")
    public void getRandom(HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.getWriter().write("********************* Request scope ********************* <br>");
            response.getWriter().write("Old number: " + requestScope.getRandomNumber() + "<br>");
            requestScope.generateRandomNumber();
            response.getWriter().write("New number: " + requestScope.getRandomNumber() + "<br>");
            response.getWriter().write("Object reference: " + requestScope + "<br><br>");
            
            response.getWriter().write("********************* Session scope ********************* <br>");
            response.getWriter().write("Old number: " + sessionScope.getRandomNumber() + "<br>");
            sessionScope.generateRandomNumber();
            response.getWriter().write("New number: " + sessionScope.getRandomNumber() + "<br>");
            response.getWriter().write("Object reference: " + sessionScope + "<br>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

