package com.kodilla.hibernate.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.CompanyFacade;
import com.kodilla.hibernate.manytomany.facade.CompanyFinderException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTestSuite {
    @Autowired
    CompanyFacade companyFacade;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFacadeFinder() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Company sqlExperts = new Company("SQL experts");
        Company javaExperts = new Company("Java experts");

        sqlExperts.getEmployees().add(johnSmith);
        javaExperts.getEmployees().add(johnSmith);

        johnSmith.getCompanies().add(sqlExperts);
        johnSmith.getCompanies().add(javaExperts);

        //When
        companyDao.save(sqlExperts);
        companyDao.save(javaExperts);

        try {
            Assert.assertEquals(1, companyFacade.companyFinder().size());
            Assert.assertEquals(1, companyFacade.employeeFinder().size());

        } catch (CompanyFinderException e) {
            //sth
        }
        //Then

    }
}
