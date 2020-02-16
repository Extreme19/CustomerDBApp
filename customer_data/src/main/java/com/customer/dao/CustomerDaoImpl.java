package com.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.entities.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	//creating an object of class SessionFactory

	@Autowired
	private SessionFactory sessionFactory;
	 //implementing the DataAccessObject interface in order to perform transactions
	
	public void saveCustomer(Customer newCustomer) {
		
		//establishing a session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		currentSession.save(newCustomer);
		// get and commit the transaction
		//currentSession.getTransaction().commit();
		
	}
	public Customer getById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer savedCustomer =  currentSession.get(Customer.class,  id);
		return savedCustomer;
	}
	public List<Customer> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> result = query.getResultList();
		return result;
		
	}
	

}
