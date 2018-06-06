package io.sample.springdemo.domain;

import io.sample.springdemo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("myorg")
public class Organization {
    
    @Value("${nameOfCompany}")
    private String companyName;
    
    @Value("${startUpYear}")
    private int yearOfIncorporation;
    
    @Value("${postalCode}")
    private String postalCode;
    
    @Value("${empCount:22222}")
    private int employeeCount;
    
    @Value("${corporateSlogan:We build world class software!}")
    private String slogan;
    
    private String missionStatement;
    
    @Autowired
    private Environment environment;
    
    private BusinessService businessService;
    
    public Organization() {
        System.out.println("Default constructor called");
    }
    
    public Organization(String companyName, int yearOfIncorporation) {
        this.companyName = companyName;
        this.yearOfIncorporation = yearOfIncorporation;
        System.out.println("Constructor called");
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
    
    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }
    
    public String corporateSlogan() {
        missionStatement = environment.getProperty("statement");
        return missionStatement + " and also " + slogan;
    }
    
    public void postConstruct() {
        System.out.println("Organization: postConstruct called...");
    }
    
    public void preDestroy() {
        System.out.println("Organization: preDestroy called...");
    }
    
    public String corporateService() {
        return businessService.offerService(companyName);
    }
    
    @Override
    public String toString() {
        return "Organization{" +
               "companyName='" + companyName + '\'' +
               ", yearOfIncorporation=" + yearOfIncorporation +
               ", postalCode='" + postalCode + '\'' +
               ", employeeCount=" + employeeCount +
               ", slogan='" + slogan + '\'' +
               ", missionStatement='" + missionStatement + '\'' +
               '}';
    }
}