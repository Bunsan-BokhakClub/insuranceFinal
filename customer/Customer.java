package customer;

import complaint.ComplaintListImpl;
import contract.Contract;

public class Customer {

	private String address;
	private int age;
	private String birth;
	private String customerID;
	private String email;
	private String gender;
	private String name;
	private String phoneNumber;
	public ComplaintListImpl complaintListImpl;
	public FamilyHistory familyHistory;
	public Contract contract;
	public PersonalHistory personalHistory;

	public Customer(String address, int age, String birth, String customerID, String email, String gender, String name, String phoneNumber, ComplaintListImpl complaintListImpl, FamilyHistory familyHistory, Contract contract, PersonalHistory personalHistory) {
		this.address = address;
		this.age = age;
		this.birth = birth;
		this.customerID = customerID;
		this.email = email;
		this.gender = gender;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.complaintListImpl = complaintListImpl;
		this.familyHistory = familyHistory;
		this.contract = contract;
		this.personalHistory = personalHistory;
	}

	public String getCustomerID(){
		return customerID;
	}

	public String getCustomerName(){
		return name;
	}

	public String getCustomerPhoneNumber(){
		return phoneNumber;
	}

	public void updateAddress(String address) {
		this.address = address;
	}

	public void updateCustomerName(String name) {
		this.name = name;
	}

	public void updateEmail(String email) {
		this.email = email;
	}

	public void updatePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}