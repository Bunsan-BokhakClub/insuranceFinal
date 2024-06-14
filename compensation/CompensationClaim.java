package compensation;

public class CompensationClaim {

	private int compensationClaimAmount;
	private String customerID;
	private String claimantName;
	private String documentFile;
	private String insuranceID;
	private String insuranceName;
	private String contractID;
	public Survey survey;

	public CompensationClaim(String customerID, String claimantName, String documentFile,
							 String insuranceID, String insuranceName) {
		this.customerID = customerID;
		this.claimantName = claimantName;
		this.documentFile = documentFile;
		this.insuranceID = insuranceID;
		this.insuranceName = insuranceName;
		this.survey = null;
		this.compensationClaimAmount = 0;
		this.contractID = customerID + insuranceID;
	}

	public int getCompensationClaimAmount() {
		return compensationClaimAmount;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getClaimantName() {
		return claimantName;
	}

	public String getDocumentFile() {
		return documentFile;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public String getContractID() {
		return contractID;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
}