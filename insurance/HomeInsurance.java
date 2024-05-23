package insurance;


public class HomeInsurance extends Insurance {

	private String homeAddress;
	private String homeType;


	public HomeInsurance(String insuranceID, String insuranceName, int paymentAmount, String homeAddress, String homeType) {
		super(insuranceID, insuranceName, paymentAmount);
		this.homeAddress = homeAddress;
		this.homeType = homeType;
	}
}