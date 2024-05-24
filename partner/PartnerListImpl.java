package partner;

import java.util.ArrayList;

public class PartnerListImpl implements PartnerList {

	private ArrayList<Partner> partnerList;
	public Partner partner;

	public PartnerListImpl(ArrayList<Partner> partnerList) {
		this.partnerList = partnerList;
	}

	public void add(Partner partner){
		partnerList.add(partner);
	}


	public void delete(){

	}

	public ArrayList<Partner> get(){
		return partnerList;
	}

	public Partner getPartnerByName(String name) {
		for (Partner partner : partnerList) {
			if (partner.getPartnerName().equals(name)) {
				return partner;
			}
		}
		return null;
	}


	public void update(){

	}

}