package compensation;

public class CompensationClaim {

	private String documentFile;
	private int compensationClaimAmount;
	private String customerID;
	private String customerName;
	private String insuranceID;
	private String insuranceName;
	public Servey servey;

	public CompensationClaim(String customerID, String customerName, String documentFile,
							 String insuranceID, String insuranceName, Servey servey) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.documentFile = documentFile;
		this.insuranceID = insuranceID;
		this.insuranceName = insuranceName;
		this.servey = servey;
		this.compensationClaimAmount = 0;
	}
}