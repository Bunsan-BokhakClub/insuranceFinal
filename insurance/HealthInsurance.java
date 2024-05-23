package insurance;

import java.util.ArrayList;

public class HealthInsurance extends Insurance {

	private ArrayList<String> DiseaseList;

	public HealthInsurance(Insurance insurance, String insuranceID, String insuranceName, int paymentAmount, ArrayList<String> diseaseList) {
		super(insuranceID, insuranceName, paymentAmount);

		DiseaseList = diseaseList;
	}
}