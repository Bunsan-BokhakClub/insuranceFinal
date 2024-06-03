package compensation;

import contract.Contract;

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

    public CompensationClaim getCompensationSlaimByID(String id) {
		for (CompensationClaim compensationClaim : compensationClaimList) {
			if (compensationClaim.getContractID().equals(id)) {
				return compensationClaim;
			}
		}
		return null;    }
}