package customer.familyHistory;

public class FamilyHistory {



	private String diseaseName;
	private String relationship;

	public FamilyHistory(String diseaseName, String relationship) {
		this.diseaseName = diseaseName;
		this.relationship = relationship;
	}

	public String getDiseaseName(){
		return diseaseName;
	}

	public String getRelationship(){
		return relationship;
	}

}