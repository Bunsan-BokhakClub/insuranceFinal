package contract;

import compensation.CompensationClaim;

public class Contract {

	private String address;
	private int age;
	private String birth;
	private int compensationAmount;
	private String concludeDate;
	private String customerID;
	private String customerName;
	private String customerStatus;
	private String cycleType;
	private String email;
	private String employeeID;
	private String employeeName;
	private String gender;
	private String insuranceID;
	private String insuranceName;

	private int paymentAmount;
	private int paymentCycle;
	private String phoneNumber;
	public CompensationClaim compensationClaim;

	public Contract(String address, int age, String birth, int compensationAmount, String concludeDate, String customerID, String customerName,
					String customerStatus, String cycleType, String email, String employeeID, String employeeName, String gender, String insuranceID,
					String insuranceName, int paymentAmount, int paymentCycle, String phoneNumber, CompensationClaim compensationClaim) {

		this.address = address;
		this.age = age;
		this.birth = birth;
		this.compensationAmount = compensationAmount;
		this.concludeDate = concludeDate;
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerStatus = customerStatus;
		this.cycleType = cycleType;
		this.email = email;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.gender = gender;
		this.insuranceID = insuranceID;
		this.insuranceName = insuranceName;
		this.paymentAmount = paymentAmount;
		this.paymentCycle = paymentCycle;
		this.phoneNumber = phoneNumber;
		this.compensationClaim = compensationClaim;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int calculateCompensationAmount(){
		return 0;
	}

	public int calculateInsuaranceFee(){
		return 0;
	}

}