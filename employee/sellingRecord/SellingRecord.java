package employee.sellingRecord;

public class SellingRecord {

	private String contractDate;
	private String customerID;
	private String insuranceID;

	public SellingRecord(String customerID, String insuranceID, String contractDate){
		this.customerID = customerID;
		this.insuranceID = insuranceID;
		this.contractDate = contractDate;
	}


	public String getContractDate() {
		return contractDate;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

}