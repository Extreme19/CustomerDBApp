package com.customer.customerimpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.customer.dao.CustomerDao;
import com.customer.entities.Customer;




@Sql(scripts = {"classpath:/db/insert_users_scripts.sql"}) //helps run the database scripts before hand and overwrites pre-existing data
@ContextConfiguration("classpath:springDemo-data-context.xml")
@RunWith(SpringRunner.class)
public class CustomerDaoImplTest {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private CustomerDao customerDaoImpl;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void saveCustomerToDatabaseTest() {
		
		logger.info("creating a new customer object");
		
		Customer newCustomer = new Customer("Joshua", "Matthew", "notMe@gmail.com","09021212345");
		
		logger.info("calling customer dao save method");
		customerDaoImpl.saveCustomer(newCustomer);
		
		logger.info("Saved customer id"+ newCustomer.getCustomerId());
		
		Customer existingCustomer =customerDaoImpl.getById(newCustomer.getCustomerId());
		assertNotNull(existingCustomer);
	}
	
	@Test
	public void getAllCustomersTest() {
		List<Customer> result = customerDaoImpl.findAll();
		
		assertNotNull(result);
		for(Customer c:result) {
			logger.info(c.toString());
		}
	}
	
	@Test
	public void saveNullCustomerTest() {
		Customer tempCustomer = new Customer();
		//customerDaoImpl.saveCustomer(tempCustomer);
		assertThrows(ConstraintViolationException.class, ()->customerDaoImpl.saveCustomer(tempCustomer));
	}
	
}
