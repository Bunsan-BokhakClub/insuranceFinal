package insurance;

public class HomeInsurance extends Insurance {

	private String homeAddress;
	private String homeType;


	public HomeInsurance(Insurance insurance, String insuranceID, String insuranceName, int paymentAmount, String homeAddress, String homeType) {
		super(insurance);

		this.homeAddress = homeAddress;
		this.homeType = homeType;
	}
}