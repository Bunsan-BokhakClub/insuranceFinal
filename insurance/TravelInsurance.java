package insurance;

import contract.Contract;

public class TravelInsurance extends Insurance {

	private String countryName;
	private int travelDate;

	public TravelInsurance(int compensationAmount, String cycleType, String insuranceName, String insuranceID, int paymentAmount, String paymentCycle, Contract contract, String countryName, int travelDate) {
		super(compensationAmount, cycleType, insuranceName, insuranceID, paymentAmount, paymentCycle, contract);
		this.countryName = countryName;
		this.travelDate = travelDate;
	}

	public String getCountryName() {
		return countryName;
	}

	public int getTravelDate() {
		return travelDate;
	}
}