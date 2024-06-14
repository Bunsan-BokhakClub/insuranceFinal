package insurance;

public class CarInsurance extends Insurance {

	private String model;

	public CarInsurance(Insurance insurance, String model) {
		super(insurance);
		this.model = model;
	}

	@Override
	public String toString() {
		return super.toString() + '\n' +
				"자동차 종류 = " + model;
	}
}