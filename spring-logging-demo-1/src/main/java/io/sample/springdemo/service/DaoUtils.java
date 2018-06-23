package io.sample.springdemo.service;

import io.sample.springdemo.dao.OrganizationDao;
import io.sample.springdemo.domain.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaoUtils {
    
    private static Logger LOGGER = LoggerFactory.getLogger("Logging Tester");
    
    public final String updateOperation = "UPDATE";
    public final String deleteOperation = "DELETE";
    public final String createOperation = "CREATE";
    public final String readOperation = "READ";
    public final String cleanupOperation = "TRUNCATE";
    
    public void printOrganizations(List<Organization> organizations, String operation) {
        LOGGER.info("\n*********** printing organizations after " + operation + " operation ************");
        for (Organization organization : organizations) {
            LOGGER.info(organization.toString());
        }
    }
    
    public void printOrganization(Organization organization, String operation) {
        LOGGER.info("\n************** Printing organization after invoking " + operation + " operation ************\n" + organization);
    }
    
    public void printSuccessFailure(String operation, boolean param) {
        if (param) {
            LOGGER.info("\nOperation " + operation + " successful");
        } else {
            LOGGER.info("\nOperation " + operation + " failed");
        }
    }
    
    public void createSeedData(OrganizationDao dao) {
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
        LOGGER.info("Created " + createCount + " organizations");
    }
    
    public void printOrganizationCount(List<Organization> organizations, String operation) {
        LOGGER.info("\n*************** Currently we have " + organizations.size() + " organizations after " + operation + " operation");
    }
}
