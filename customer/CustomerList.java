package customer;

public interface CustomerList {
	public void add(Customer customer);

	public void delete(String customerID);

	public void get();

	public void update();

	Customer getCustomerByID(String customerId);
}