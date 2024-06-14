package customer;

import exception.CustomException;

import java.util.ArrayList;

public interface CustomerList {
	void add(Customer customer);

	void delete(String customerID);

	ArrayList<Customer> get();

	void update();

	Customer getCustomerByID(String customerId) throws CustomException;

}