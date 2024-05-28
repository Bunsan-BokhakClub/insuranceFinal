package insurance;

import contract.Contract;

import java.util.ArrayList;
import java.util.List;

public class Insurance {

	private int compensationAmount; //보상금
	private String cycleType; //갱신, 비갱신
	private String insuranceName;
	private String insuranceID;
	private String insurancePeriod; //보험 기간.
	private int paymentAmount; //보험료
	private String paymentCycle; //갱신 주기

	private List<String> customerIDs;

	public Insurance(int compensationAmount, String cycleType, String insuranceName,
					 String insuranceID, int paymentAmount,
					 String paymentCycle, String insurancePeriod) {
		this.compensationAmount = compensationAmount;
		this.cycleType = cycleType;
		this.insuranceName = insuranceName;
		this.insuranceID = insuranceID;
		this.insurancePeriod = insurancePeriod;
		this.paymentAmount = paymentAmount;
		this.paymentCycle = paymentCycle;
	}




	public String getInsuranceID() {
		return insuranceID;
	}

	public List<String> getCustomerIDs() {
		return customerIDs;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public int getPaymentAmount() {
		return paymentAmount;
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

	public void addCustomerID(String customerID) {
		this.customerIDs.add(customerID);
	}

	public void updateCompensation(int compensationAmount) {
		this.compensationAmount = compensationAmount;
	}

	public void updateInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public void updatePayment(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public void updatePaymentCycle(String paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public int getCompensationAmount() {
		return compensationAmount;
	}

	public String getCycleType() {
		return cycleType;
	}


	public String getPaymentCycle() {
		return paymentCycle;
	}

	public String getInsurancePeriod() {
		return insurancePeriod;
	}

	public void setCompensationAmount(int compensationAmount) {
		this.compensationAmount = compensationAmount;
	}

	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}


	public void setPaymentCycle(String paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public void setInsurancePeriod(String insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
	}
}