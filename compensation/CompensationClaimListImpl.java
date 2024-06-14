package compensation;

import contract.Contract;
import exception.CustomException;

import java.util.ArrayList;

public class CompensationClaimListImpl implements CompensationClaimList {

	private ArrayList<CompensationClaim> compensationClaimList;

	public CompensationClaimListImpl(){
		this.compensationClaimList = new ArrayList<CompensationClaim>();
	}


	public void add(CompensationClaim compensationClaim){
		compensationClaimList.add(compensationClaim);
	}
	public void delete(){

	}

	public ArrayList<CompensationClaim> get() {
		return compensationClaimList;
	}

	public void update(){

	}

    public CompensationClaim getCompensationClaimByID(String id) throws CustomException {
		for (CompensationClaim compensationClaim : compensationClaimList) {
			if (compensationClaim.getContractID().equals(id)) {
				return compensationClaim;
			}
		}
		throw new CustomException("해당 정보가 존재하지 않습니다.");
	}
}