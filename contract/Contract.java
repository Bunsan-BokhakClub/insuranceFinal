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
					String customerStatus, String cycleType, String email, String employeeID, String employeeName,
					String gender, String insuranceID, String insuranceName, int paymentAmount, int paymentCycle,
					String phoneNumber, CompensationClaim compensationClaim) {

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

	//********************* Getter 및 Setter 메서드************************
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

	public int getCompensationAmount() {
		return compensationAmount;
	}

	public void setCompensationAmount(int compensationAmount) {
		this.compensationAmount = compensationAmount;
	}

	public String getConcludeDate() {
		return concludeDate;
	}

	public void setConcludeDate(String concludeDate) {
		this.concludeDate = concludeDate;
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
	

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getCycleType() {
		return cycleType;
	}

	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}


	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}


	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getPaymentCycle() {
		return paymentCycle;
	}

	public void setPaymentCycle(int paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CompensationClaim getCompensationClaim() {
		return compensationClaim;
	}

	public void setCompensationClaim(CompensationClaim compensationClaim) {
		this.compensationClaim = compensationClaim;
	}

	//********************* Getter 및 Setter 메서드************************

	// 보상액 계산 메서드
	public int calculateCompensationAmount() {
		// 보상액 계산 로직
		return compensationAmount;
	}

	// 보험료 계산 메서드
	public int calculateInsuranceFee() {
		// 보험료 계산 로직
		return paymentAmount * paymentCycle;
	}
}
