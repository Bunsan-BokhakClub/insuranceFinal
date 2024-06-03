package insurance;

public class CarInsurance extends Insurance {

	private String distance;
	private String model;
	private String year;

	public CarInsurance(Insurance insurance, String distance, String model, String year) {
		super(insurance);
		this.distance = distance;
		this.model = model;
		this.year = year;
	}
}