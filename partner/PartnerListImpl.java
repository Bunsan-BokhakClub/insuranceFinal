package partner;

import java.util.ArrayList;

public class PartnerListImpl implements PartnerList {

	private ArrayList<Partner> partnerList;

	public PartnerListImpl(ArrayList<Partner> partnerList) {
		this.partnerList = partnerList;
	}

	public void add(){

	}

	public void delete(){

	}

	public Partner getPartnerByName(String name){
		return partnerList.stream()
				.filter(partner -> partner.getPartnerName().equals(name))
				.findFirst()
				.orElse(null);
	}

	public void update(){

	}

}