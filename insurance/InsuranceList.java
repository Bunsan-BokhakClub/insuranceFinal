package insurance;

import java.util.ArrayList;
import java.util.List;

public interface InsuranceList {

	void add(Insurance insurance);

	void delete(String insuranceID);

	Insurance getInsuranceByID(String insuranceID);

    Insurance getInsuranceByName(String insuranceName);

	public ArrayList<Insurance> get();

}
