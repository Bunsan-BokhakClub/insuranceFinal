package compensation;

import java.util.ArrayList;

public class CompensationClaimListImpl implements CompensationClaimList {

	private ArrayList<CompensationClaim> compensationList;

	public CompensationClaimListImpl(ArrayList<CompensationClaim> compensationList) {
		this.compensationList = compensationList;
	}


	public void add(CompensationClaim compensationClaim){
		compensationList.add(compensationClaim);
	}

	public void delete(){

	}

	public void get(){

	}

	public void update(){

	}

}