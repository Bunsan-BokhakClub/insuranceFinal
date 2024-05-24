package partner;

public class Partner {

	private int partnerID;
	private String partnerName;
	private int partnerRate;
	private String partnerType;
	private String partnerAddress;
	private String partnerContactInformation;

	public Partner(String partnerName, String partnerType, String partnerAddress, String partnerContactInformation) {
		this.partnerName = partnerName;
		this.partnerType = partnerType;
		this.partnerAddress = partnerAddress;
		this.partnerContactInformation = partnerContactInformation;
	}

	public int getPartnerID() {
		return partnerID;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public int getPartnerRate() {
		return partnerRate;
	}

	public void setPartnerRate(int partnerRate) {
		this.partnerRate = partnerRate;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public String getPartnerAddress() {
		return partnerAddress;
	}

	public String getPartnerContactInformation() {
		return partnerContactInformation;
	}
}