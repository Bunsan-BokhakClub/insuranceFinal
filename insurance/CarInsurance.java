package insurance;

import contract.Contract;

public class CarInsurance extends Insurance {

	private int distance;
	private String model;
	private String year;

	public CarInsurance(int compensationAmount, String cycleType, String insuranceName, String insuranceID, int paymentAmount, String paymentCycle, Contract contract, int distance, String model, String year) {
		super(compensationAmount, cycleType, insuranceName, insuranceID, paymentAmount, paymentCycle, contract);
		this.distance = distance;
		this.model = model;
		this.year = year;
	}
}