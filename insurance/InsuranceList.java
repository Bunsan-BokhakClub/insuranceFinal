package insurance;

import exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public interface InsuranceList {

	void add(Insurance insurance);

	void delete(String insuranceID);

	Insurance getInsuranceByID(String insuranceID) throws CustomException;

    Insurance getInsuranceByName(String insuranceName) throws CustomException;

	 ArrayList<Insurance> get();

}
