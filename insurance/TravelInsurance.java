package insurance;

public class TravelInsurance extends Insurance {

	private String countryName;

	public TravelInsurance(Insurance insurance, String countryName) {
		super(insurance);
		this.countryName = countryName;

	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return super.toString() + '\n' +
				"국가 = " + countryName;
	}
}