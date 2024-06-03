package partner;

import partner.rate.RateListImpl;

public class Partner {

	private int partnerID;
	private String partnerName;
	private String partnerType;
	private String partnerAddress;
	private String partnerPhoneNumber;

	public RateListImpl getRateList() {
		return rateList;
	}

	private RateListImpl rateList;

	public Partner(String partnerName, String partnerType, String partnerAddress, String partnerContactInformation) {
		this.partnerName = partnerName;
		this.partnerType = partnerType;
		this.partnerAddress = partnerAddress;
		this.partnerPhoneNumber = partnerContactInformation;

		this.rateList = new RateListImpl();
	}

	public int getPartnerID() {
		return partnerID;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public String getPartnerAddress() {
		return partnerAddress;
	}

	public String getPartnerPhoneNumber() {
		return partnerPhoneNumber;
	}
}