package insurance;


import contract.Contract;

public class HomeInsurance extends Insurance {

	private String homeAddress;
	private String homeType;

	public HomeInsurance(int compensationAmount, String cycleType, String insuranceName, String insuranceID, int paymentAmount, String paymentCycle, Contract contract, String homeAddress, String homeType) {
		super(compensationAmount, cycleType, insuranceName, insuranceID, paymentAmount, paymentCycle, contract);
		this.homeAddress = homeAddress;
		this.homeType = homeType;
	}
}