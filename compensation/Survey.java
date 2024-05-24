package compensation;

import partner.Partner;

public class Survey {

	private int customerID;
	private int insuranceID;
	private String managerName;
	private int surveyAmount;
	private String reason;
	public Partner partner;

	public Survey(int customerID, int insuranceID, String managerName, int surveyAmount , String reason) {
		this.customerID = customerID;
		this.insuranceID = insuranceID;
		this.managerName = managerName;
		this.surveyAmount = surveyAmount;
		this.reason = reason;
	}

	public int getCustomerID() {
		return customerID;
	}

	public int getInsuranceID() {
		return insuranceID;
	}

	public String getManagerName() {
		return managerName;
	}

	public int getSurveyAmount() {
		return surveyAmount;
	}

	public String getReason() {
		return reason;
	}

	public Partner getPartner() {
		return partner;
	}
}