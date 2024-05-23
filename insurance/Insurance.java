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
	//어떤 고객이 든 보험을 조회 하려면 필요함.
	// 한 보험에 대해 여러명의 유저가 가입할 수 있으니 list로 설정함.



	public Insurance(String insuranceID, String insuranceName, int paymentAmount) {
		this.insuranceID = insuranceID;
		this.insuranceName = insuranceName;
		this.paymentAmount = paymentAmount;
		this.customerIDs = new ArrayList<>();//처음 보험이 만들어 질 때는 유저가 없으니 빈 리스트
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
=======
package insurance;

public class Insurance {

	private int compensationAmount;
	private String cycleType;
	private String insuranceName;
	private String insuranceID;
	private int paymentAmount;
	private String paymentCycle;
	private String insurancePeriod;

// 	public Insurance(int insuranceID, String insuranceName, int compensationAmount, String cycleType,
// 					 int paymentAmount, int paymentCycle, int insurancePeriod) {
// 		this.insuranceID = Integer.toString(insuranceID);
// 		this.compensationAmount = compensationAmount;
// 		this.cycleType = cycleType;
// 		this.insuranceName = insuranceName;
// 		this.paymentAmount = paymentAmount;
// 		this.paymentCycle = Integer.toString(paymentCycle);
// 		this.insurancePeriod = Integer.toString(insurancePeriod);
// 	}

// 	public Insurance(Insurance insurance) {
// 		this.insuranceID = insurance.getInsuranceID();
// 		this.compensationAmount = insurance.getCompensationAmount();
// 		this.cycleType = insurance.getCycleType();
// 		this.insuranceName = insurance.getInsuranceName();
// 		this.paymentAmount = insurance.getPaymentAmount();
// 		this.paymentCycle = insurance.getPaymentCycle();
// 		this.insurancePeriod = insurance.getInsurancePeriod();
// 	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public int getCompensationAmount() {
		return compensationAmount;
	}

	public String getCycleType() {
		return cycleType;
	}

	public int getPaymentAmount() {
		return paymentAmount;
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

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public void setPaymentCycle(String paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public void setInsurancePeriod(String insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
	}
}