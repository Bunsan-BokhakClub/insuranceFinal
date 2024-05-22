package insurance;

import contract.Contract;

import java.util.ArrayList;

public class HealthInsurance extends Insurance {

	private ArrayList<String> DiseaseList;

	public HealthInsurance(int compensationAmount, String cycleType, String insuranceName, String insuranceID, int paymentAmount, String paymentCycle, Contract contract, ArrayList<String> diseaseList) {
		super(compensationAmount, cycleType, insuranceName, insuranceID, paymentAmount, paymentCycle, contract);
		DiseaseList = diseaseList;
	}
}