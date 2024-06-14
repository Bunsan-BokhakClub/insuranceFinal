package partner;

import exception.CustomException;

import java.util.ArrayList;

public class PartnerListImpl implements PartnerList {

	private ArrayList<Partner> partnerList;
	public Partner partner;

	public PartnerListImpl() {
		this.partnerList = new ArrayList<Partner>();
	}

	public void add(Partner partner){
		partnerList.add(partner);
	}


	public void delete(){

	}

	public ArrayList<Partner> get(){
		return partnerList;
	}

	public Partner getPartnerByName(String name) throws CustomException{
		for (Partner partner : partnerList) {
			if (partner.getPartnerName().equals(name)) {
				return partner;
			}
		}
		throw new CustomException("해당 정보가 존재하지 않습니다.");
	}


	public void update(){

	}

}