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
        String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code,employee_count, slogan) " + "VALUES (?, ?, ?,"
                          + " ?, ?)";
        Object[] args = new Object[]{organization.getCompanyName(), organization.getYearOfIncorporation(), organization.getPostalCode(),
        organization.getEmployeeCount(), organization.getSlogan()};
        
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }
    
    public Organization getOrganization(Integer id) {
        String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan FROM organization WHERE id = ?";
        Object[] args = new Object[]{id};
        return (Organization) jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
    }
    
    public List<Organization> getAllOrganizations() {
        String sqlQuery = "SELECT * FROM organization";
        return jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
    }
    
    public boolean delete(Organization organization) {
        String sqlQuery = "DELETE FROM organization WHERE id = ?";
        Object[] args = new Object[]{organization.getId()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }
    
    public boolean update(Organization organization) {
        String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
        Object[] args = new Object[]{organization.getSlogan(), organization.getId()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }
    
    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE organization ";
        jdbcTemplate.execute(sqlQuery);
    }
}
