package customer;

import java.util.ArrayList;

public interface CustomerList {
	public void add(Customer customer);

	public void delete(String customerID);

	public ArrayList<Customer> get();

	public void update();

	Customer getCustomerByID(String customerId);

    Customer getCustomerByPhoneNumber(String phoneNumber);
}