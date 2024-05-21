package customer;

import complaint.ComplaintListImpl;
import contract.Contract;

public class Customer {

	private String adress;
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

	public Customer(String adress, int age, String birth, String customerID, String email, String gender, String name, String phoneNumber, ComplaintListImpl complaintListImpl, FamilyHistory familyHistory, Contract contract, PersonalHistory personalHistory) {
		this.adress = adress;
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

	public Customer(){

	}

	public String getCustomerID(){
		return "";
	}

	public String getCustomerName(){
		return "";
	}

	public String getCustomerPhoneNumber(){
		return "";
	}

	public void updateAdress(){

	}

	public void updateCustomerName(){

	}

	public void updateEmail(){

	}

	public void updatePhoneNumber(){

	}
}