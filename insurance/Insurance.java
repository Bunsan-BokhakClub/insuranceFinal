package insurance;

import contract.Contract;

import java.util.ArrayList;
import java.util.List;

public class Insurance {

	private int compensationAmount;
	private String cycleType;
	private String insuranceName;
	private String insuranceID;
	private int paymentAmount;
	private String paymentCycle;
	public Contract contract;
  private String insurancePeriod;


	private List<String> customerIDs;

	public Insurance(String insuranceID, String insuranceName, int compensationAmount, String cycleType,
					 int paymentAmount, int paymentCycle, int insurancePeriod) {
		this.insuranceID = insuranceID;
		this.compensationAmount = compensationAmount;
		this.cycleType = cycleType;
		this.insuranceName = insuranceName;
		this.paymentAmount = paymentAmount;
		this.paymentCycle = Integer.toString(paymentCycle);
		this.insurancePeriod = Integer.toString(insurancePeriod);
		this.customerIDs = new ArrayList<>(); // 초기화
	}

	// 복사 생성자
	public Insurance(Insurance insurance) {
		this.insuranceID = insurance.insuranceID;
		this.compensationAmount = insurance.compensationAmount;
		this.cycleType = insurance.cycleType;
		this.insuranceName = insurance.insuranceName;
		this.paymentAmount = insurance.paymentAmount;
		this.paymentCycle = insurance.paymentCycle;
		this.insurancePeriod = insurance.insurancePeriod;
		this.customerIDs = new ArrayList<>(insurance.customerIDs);
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