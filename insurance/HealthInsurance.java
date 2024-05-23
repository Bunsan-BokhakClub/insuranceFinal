package insurance;

import java.util.ArrayList;

public class HealthInsurance extends Insurance {

	private ArrayList<String> diseaseList;

	public HealthInsurance(Insurance insurance, ArrayList<String> diseaseList) {
		super(insurance); // 복사 생성자를 호출합니다.

		this.diseaseList = diseaseList;
	}

	public ArrayList<String> getDiseaseList() {
		return diseaseList;
	}

	public void setDiseaseList(ArrayList<String> diseaseList) {
		this.diseaseList = diseaseList;
	}
}
