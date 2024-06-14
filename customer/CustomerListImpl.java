package customer;
import exception.CustomException;

import java.util.ArrayList;

public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList;

	public CustomerListImpl(){
		customerList = new ArrayList<Customer>();
	}

	public void add(Customer customer){
		customerList.add(customer);
	}

	public void delete(String customerID){
		customerList.removeIf(customer -> customer.getCustomerID().equals(customerID));
	}

	public Customer getCustomerByID(String customerID) throws CustomException {
		for (Customer customer : customerList) {
			if (customer.getCustomerID().equals(customerID)) {
				return customer;
			}
		}
		throw new CustomException("해당 정보가 존재하지 않습니다.");
	}

	public ArrayList<Customer> get(){
		return customerList;
	}

	public void update(){

	}

}