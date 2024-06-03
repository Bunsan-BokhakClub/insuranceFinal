package contract;

import compensation.CompensationClaim;
import compensation.CompensationClaimList;
import compensation.CompensationClaimListImpl;

import java.util.ArrayList;

public class Contract {


	private String customerID;
	private String customerName;
	private String gender;
	private String birth;
	private String phoneNumber;
	private String address;
	private String insuranceID;
	private String insuranceName;
	private int paymentAmount;
	private int compensationAmount;
	private String cycleType;
	private String paymentCycle;



	private String insurancePeriod; //보험 기간.
	private boolean contractStatus;
	private boolean isPayment;

	private int cancelMoney;




	private String contractID;
	private int age;
	private String concludeDate;

	private String email;




	public CompensationClaimListImpl compensationClaimList;

	public Contract(String address, int age, String birth, int compensationAmount, String concludeDate, String customerID, String customerName,
					String cycleType, String email,
					String gender, String insuranceID, String insuranceName, int paymentAmount, String paymentCycle,
					String phoneNumber, String insurancePeriod) {

		this.address = address;
		this.age = age;
		this.birth = birth;
		this.compensationAmount = compensationAmount;
		this.concludeDate = concludeDate;
		this.customerID = customerID;
		this.customerName = customerName;
		this.cycleType = cycleType;
		this.email = email;
		this.gender = gender;
		this.insuranceID = insuranceID;
		this.insuranceName = insuranceName;
		this.paymentAmount = paymentAmount;
		this.paymentCycle = paymentCycle;
		this.phoneNumber = phoneNumber;
		this.contractStatus = true;
		this.isPayment = true;
		this.insurancePeriod = insurancePeriod;

		this.compensationClaimList = new CompensationClaimListImpl();
		this.contractID = customerID + insuranceID;
		this.cancelMoney = 0;
	}

	@Override
	public String toString() {
		return "Contract{" +
				"contractID='" + contractID + '\n' +
				", customerID='" + customerID + '\n' +
				", customerName='" + customerName + '\n' +
				", gender='" + gender + '\n' +
				", birth='" + birth + '\n' +
				", phoneNumber='" + phoneNumber + '\n' +
				", address='" + address + '\n' +
				", insuranceID='" + insuranceID + '\n' +
				", insuranceName='" + insuranceName + '\n' +
				", paymentAmount=" + paymentAmount + '\n' +
				", compensationAmount=" + compensationAmount + "\n" +
				", cycleType='" + cycleType + '\n' +
				", paymentCycle='" + paymentCycle + '\n' +
				", insurancePeriod='" + insurancePeriod + '\n' +
				", contractStatus=" + contractStatus + '\n' +
				", isPayment=" + isPayment + '\n' +
				'}' +'\n' + "\n";
	}

	private static double calculateRefund() {
		// 환급금 계산 로직 (예시)
		// 실제 로직은 보험사의 환급 정책에 따라 다를 수 있음
		double totalPaidAmount = 1000000; // 총 납부 금액 (예시)
		double refundRate = 0.8; // 환급 비율 (예시)
		return totalPaidAmount * refundRate;
	}

	//********************* Getter 및 Setter 메서드************************
	public int getCancelMoney() {
		return cancelMoney;
	}

	public void setCancelMoney(int cancelMoney) {
		this.cancelMoney = cancelMoney;
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
	public String getInsurancePeriod() {
		return insurancePeriod;
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

	public String getPaymentCycle() {
		return paymentCycle;
	}

	public void setPaymentCycle(String paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
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
//		return paymentAmount * paymentCycle;
		return 0;
	}
}
