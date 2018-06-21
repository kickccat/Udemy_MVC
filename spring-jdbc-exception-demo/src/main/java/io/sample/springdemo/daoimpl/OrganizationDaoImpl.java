package io.sample.springdemo.daoimpl;

import io.sample.springdemo.dao.OrganizationDao;
import io.sample.springdemo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public boolean create(Organization organization) {
        return false;
    }
    
    public Organization getOrganization(Integer id) {
        return null;
    }
    
    public List<Organization> getAllOrganizations() {
        String sqlQuery = "SELECT * FROM organization";
        return jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
    }
    
    public boolean delete(Organization organization) {
        return false;
    }
    
    public boolean update(Organization organization) {
        return false;
    }
    
    public void cleanup() {
    
    }
}
