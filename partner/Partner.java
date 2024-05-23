package partner;

public class Partner {

	private String partnerID;
	private String partnerName;
	private String partnerRate;
	private String partnerType;


	public Partner(String partnerID, String partnerName, String partnerRate, String partnerType) {
		this.partnerID = partnerID;
		this.partnerName = partnerName;
		this.partnerRate = partnerRate;
		this.partnerType = partnerType;
	}

	public String getPartnerName() {
		return partnerName;
	}
}