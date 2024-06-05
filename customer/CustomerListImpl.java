package customer;
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

	public Customer getCustomerByID(String customerID) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID().equals(customerID)) {
				return customer;
			}
		}
		return null;
	}

	public ArrayList<Customer> get(){
		return customerList;
	}

	public void update(){

	}

}