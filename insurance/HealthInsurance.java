package insurance;

import java.util.ArrayList;

public class HealthInsurance extends Insurance {

	private ArrayList<String> DiseaseList;

	public HealthInsurance(Insurance insurance, ArrayList<String> diseaseList) {
		super(insurance);
		DiseaseList = diseaseList;
	}
}