package io.sample.springdemo;

import io.sample.springdemo.dao.OrganizationDao;
import io.sample.springdemo.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class DaoUtils {
    
    static final String createOperation = "CREATE";
    static final String readOperation = "READ";
    public static final String updateOperation = "UPDATE";
    public static final String deleteOperation = "DELETE";
    static final String cleanupOperation = "TRUNCATE";
    
    static void printOrganizations(List<Organization> organizations, String operation) {
        System.out.println("\n*********** printing organizations after " + operation + " operation ************");
        for (Organization organization : organizations) {
            System.out.println(organization);
        }
    }
    
    static  void printOrganization(Organization organization, String operation) {
        System.out.println("\n************** Printing organization after invoking " + operation + " operation ************\n" + organization);
    }
    
    static void printSuccessFailure(String operation, boolean param) {
        if (param) {
            System.out.println("\nOperation " + operation + " successful");
        } else {
            System.out.println("\nOperation " + operation + " failed");
        }
    }
    
    static void createSeedData(OrganizationDao dao) {
        Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
        Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");
        Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");
    
        List<Organization> organizations = new ArrayList<Organization>();
        organizations.add(0, org1);
        organizations.add(1, org2);
        organizations.add(2, org3);
    
        int createCount = 0;
        for (Organization organization : organizations) {
            boolean isCreated = dao.create(organization);
            if (isCreated) {
                createCount++;
            }
        }
        System.out.println("Created " + createCount + " organizations");
    }
    
    static void printOrganizationCount(List<Organization> organizations, String operation) {
        System.out.println("\n*************** Currently we have " + organizations.size() + " organizations after " + operation + " operation");
    }
}
