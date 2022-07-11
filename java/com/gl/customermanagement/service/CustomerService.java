package com.gl.customermanagement.service;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.customermanagement.entityclass.Customer;

// repository class to perform CURD operation.
@Repository
public class CustomerService {
	
    // hibernet session factory.
	private SessionFactory sessionFactory;

	// create session
	private Session session;
	
	@Autowired
	public CustomerService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	@Transactional
	public List<Customer> findAllCustomer(){
		Transaction tx = session.beginTransaction();
		List<Customer> customers =session.createQuery("from Customer").list();
		tx.commit();
		return customers;
	}
	@Transactional
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}
	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();
	}
	@Transactional
	public Customer findById(int id) {
		Customer customer=new Customer();
		Transaction tx = session.beginTransaction();
		customer = session.get(Customer.class, id);

		tx.commit();

		return customer;
	}
	}