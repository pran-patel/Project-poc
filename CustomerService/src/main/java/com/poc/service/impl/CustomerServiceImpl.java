package com.poc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entities.Customer;
import com.poc.exception.CustomerNotFoundException;
import com.poc.repository.CustomerRepository;
import com.poc.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByEmailId(String emailId)  {
		Optional<Customer> customer = customerRepository.findByEmailId(emailId);
		if(customer.isPresent())
		{
			return customer.get();
		}
		else
		{
			throw new CustomerNotFoundException("Customer not found -----------");
		}
//		try {
//			Optional<Customer> customer = customerRepository.findByEmailId(emailId);
//			System.out.println(customer+".................");
//			System.out.println(customer.get()+".............");
//			return customer.get();
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage()); 
//		}
	//return customer;
	}

}
