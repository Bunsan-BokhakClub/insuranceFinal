package insurance;

public class Insurance {

	private int compensationAmount;
	private String cycleType;
	private String insuranceName;
	private String insuranceID;
	private int paymentAmount;
	private String paymentCycle;
	private String insurancePeriod;

	public Insurance(int insuranceID, String insuranceName, int compensationAmount, String cycleType,
					 int paymentAmount, int paymentCycle, int insurancePeriod) {
		this.insuranceID = Integer.toString(insuranceID);
		this.compensationAmount = compensationAmount;
		this.cycleType = cycleType;
		this.insuranceName = insuranceName;
		this.paymentAmount = paymentAmount;
		this.paymentCycle = Integer.toString(paymentCycle);
		this.insurancePeriod = Integer.toString(insurancePeriod);
	}

	public Insurance(Insurance insurance) {
		this.insuranceID = insurance.getInsuranceID();
		this.compensationAmount = insurance.getCompensationAmount();
		this.cycleType = insurance.getCycleType();
		this.insuranceName = insurance.getInsuranceName();
		this.paymentAmount = insurance.getPaymentAmount();
		this.paymentCycle = insurance.getPaymentCycle();
		this.insurancePeriod = insurance.getInsurancePeriod();
	}

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