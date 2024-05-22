package insurance;

public class HomeInsurance extends Insurance {

	private String homeAddress;
	private String homeType;

	public HomeInsurance(Insurance insurance, String homeAddress, String homeType) {
		super(insurance);
		this.homeAddress = homeAddress;
		this.homeType = homeType;
	}
}