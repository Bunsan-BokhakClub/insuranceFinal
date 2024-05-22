package insurance;

public class TravelInsurance extends Insurance {

	private String countryName;
	private int travelDate;

	public TravelInsurance(Insurance insurance, String countryName, int travelDate) {
		super(insurance);
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