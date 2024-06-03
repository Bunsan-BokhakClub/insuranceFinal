package customer.personalHistory;

public class PersonalHistory {



	private String diseaseName;
	private String occurDate;

	public PersonalHistory(String diseaseName, String occurDate) {
		this.diseaseName = diseaseName;
		this.occurDate = occurDate;
	}

	public String gertDiseaseName(){
		return diseaseName;
	}

	public String getOccurDate(){
		return occurDate;
	}

}