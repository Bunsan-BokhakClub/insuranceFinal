package compensation;

import partner.Partner;

public class Survey {

	private String customerID;
	private String insuranceID;
	private String managerName;
	private int surveyAmount;
	private String reason;
	public Partner partner;

	public Survey(String customerID, String insuranceID, String managerName, int surveyAmount , String reason) {
		this.customerID = customerID;
		this.insuranceID = insuranceID;
		this.managerName = managerName;
		this.surveyAmount = surveyAmount;
		this.reason = reason;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getInsuranceID() {
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