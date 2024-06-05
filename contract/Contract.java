package contract;

import compensation.CompensationClaim;
import compensation.CompensationClaimList;
import compensation.CompensationClaimListImpl;
import payment.PaymentListImpl;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
	private String contractID;
	private int age;
	private String concludeDate;
	private String email;
	private String endDate;
	private PaymentListImpl paymentList;
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
		this.endDate = addYearsToDate();
		this.paymentList = new PaymentListImpl();
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


	public String addYearsToDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(this.concludeDate, formatter);
		LocalDateTime newDateTime = dateTime.plusYears(Integer.parseInt(this.insurancePeriod));
		return newDateTime.format(formatter);
	}

	public double carculateCancelMoney(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime endDateTime = LocalDateTime.parse(this.endDate, formatter);

		Period endPeriod = Period.between(now.toLocalDate(), endDateTime.toLocalDate());
		int endTotalMonths = endPeriod.getYears() * 12 + endPeriod.getMonths();
		if (endTotalMonths > 12) {
			return this.paymentAmount * 0.6;
		} else if (endTotalMonths > 0) {
			return this.paymentAmount * 0.4;
		} else {
			return 0; // 만기일이 지났거나 오늘인 경우 환급금 없음
		}
	}

	//********************* Getter 및 Setter 메서드************************

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getCompensationAmount() {
		return compensationAmount;
	}

	public void setCompensationAmount(int compensationAmount) {
		this.compensationAmount = compensationAmount;
	}

	public String getCycleType() {
		return cycleType;
	}

	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}

	public String getPaymentCycle() {
		return paymentCycle;
	}

	public void setPaymentCycle(String paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public String getInsurancePeriod() {
		return insurancePeriod;
	}

	public void setInsurancePeriod(String insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
	}

	public boolean isContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(boolean contractStatus) {
		this.contractStatus = contractStatus;
	}

	public boolean isPayment() {
		return isPayment;
	}

	public void setPayment(boolean payment) {
		isPayment = payment;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getConcludeDate() {
		return concludeDate;
	}

	public void setConcludeDate(String concludeDate) {
		this.concludeDate = concludeDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public PaymentListImpl getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(PaymentListImpl paymentList) {
		this.paymentList = paymentList;
	}

	public CompensationClaimListImpl getCompensationClaimList() {
		return compensationClaimList;
	}

	public void setCompensationClaimList(CompensationClaimListImpl compensationClaimList) {
		this.compensationClaimList = compensationClaimList;
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
