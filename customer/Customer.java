package customer;

import complaint.ComplaintListImpl;
import contract.Contract;
import customer.familyHistory.FamilyHistory;
import customer.familyHistory.FamilyHistoryImpl;
import customer.personalHistory.PersonalHistory;
import customer.personalHistory.PersonalHistoryImpl;

public class Customer {

	private String address;
	private int age;
	private String birth;
	private String customerID;
	private String email;
	private String gender;
	private String name;
	private String job;
	private String phoneNumber;
	public ComplaintListImpl complaintListImpl;
	public FamilyHistoryImpl familyHistoryList;
	public PersonalHistoryImpl personalHistoryList;

	@Override
	public String toString() {
		return 	"고객 ID = " + customerID + '\n' +
				", 이름 = " + name + '\n' +
				", 성별 = " + gender + '\n' +
				", 생년월일 = " + birth + '\n' +
				", 전화번호 = " + phoneNumber + '\n' +
				", 이메일 = " + email + '\n' +
				", 주소 = " + address + '\n' +
				", 직업 = " + job + '\n' +
				", 가족력 리스트 : " + '\n' + familyHistoryList.toString() + '\n' +
				", 개인병력 리스트 : " + '\n' +personalHistoryList.toString();
	}

	public Customer(String customerID, String name, String gender, String birth,
					String phoneNumber, String email, String address, String job,
					FamilyHistoryImpl familyHistoryList, PersonalHistoryImpl personalHistoryList) {
		this.customerID = customerID;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birth = birth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.job = job;
		this.familyHistoryList = familyHistoryList;
		this.personalHistoryList = personalHistoryList;

		this.complaintListImpl = new ComplaintListImpl();
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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

	public FamilyHistoryImpl getFamilyHistoryList() {
		return familyHistoryList;
	}

	public void setFamilyHistoryList(FamilyHistoryImpl familyHistoryList) {
		this.familyHistoryList = familyHistoryList;
	}

	public PersonalHistoryImpl getPersonalHistoryList() {
		return personalHistoryList;
	}

	public void setPersonalHistoryList(PersonalHistoryImpl personalHistoryList) {
		this.personalHistoryList = personalHistoryList;
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