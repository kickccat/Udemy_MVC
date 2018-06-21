package io.sample.springdemo.dao;

import io.sample.springdemo.domain.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDao {
    
    void setDataSource(DataSource dataSource);
    
    boolean create(Organization organization);
    
    Organization getOrganization(Integer id);
    
    List<Organization> getAllOrganizations();
    
    boolean delete(Organization organization);
    
    boolean update(Organization organization);
    
    void cleanup();
}
