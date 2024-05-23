package customer;


import java.util.ArrayList;

public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList;
	public Customer m_Customer;

	public CustomerListImpl(){

	}

	public void add(Customer customer){
		customerList.add(customer);
	}

	public void delete(String customerID){
		customerList.removeIf(customer -> customer.getCustomerID().equals(customerID));
	}

	public Customer getCustomerByID(String customerID) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID().equals(customerID)) {
				return customer;
			}
		}
		return null;
	}






	public void get(){

	}

	public void update(){

	}

}