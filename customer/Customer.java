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


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ComplaintListImpl getComplaintListImpl() {
		return complaintListImpl;
	}

	public void setComplaintListImpl(ComplaintListImpl complaintListImpl) {
		this.complaintListImpl = complaintListImpl;
	}

	public FamilyHistory getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(FamilyHistory familyHistory) {
		this.familyHistory = familyHistory;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public PersonalHistory getPersonalHistory() {
		return personalHistory;
	}

	public void setPersonalHistory(PersonalHistory personalHistory) {
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