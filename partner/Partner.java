package partner;

import partner.rate.RateListImpl;

public class Partner {

	private String partnerID;
	private String partnerName;
	private String partnerType;
	private String partnerAddress;
	private String partnerPhoneNumber;
	private RateListImpl rateList;

	public RateListImpl getRateList() {
		return rateList;
	}


	public Partner(String partnerName, String partnerType, String partnerAddress, String partnerContactInformation) {
		this.partnerName = partnerName;
		this.partnerType = partnerType;
		this.partnerAddress = partnerAddress;
		this.partnerPhoneNumber = partnerContactInformation;

		this.rateList = new RateListImpl();
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