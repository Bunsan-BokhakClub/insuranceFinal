package insurance;

import exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class InsuranceListImpl implements InsuranceList {

    private ArrayList<Insurance> insuranceList;

    public InsuranceListImpl() {
        this.insuranceList = new ArrayList<Insurance>();
    }

    @Override
    public void add(Insurance insurance) {
        insuranceList.add(insurance);
    }

    @Override
    public void delete(String insuranceID) {
        insuranceList.removeIf(insurance -> insurance.getInsuranceID().equals(insuranceID));
    }

    @Override
    public Insurance getInsuranceByID(String insuranceID) throws CustomException {
        for (Insurance insurance : insuranceList) {
            if (insurance.getInsuranceID().equals(insuranceID)) {
                return insurance;
            }
        }
        throw new CustomException("해당 정보가 존재하지 않습니다.");
    }

    public Insurance getInsuranceByName(String insName) throws CustomException{
        return insuranceList.stream()
                .filter(insurance -> insurance.getInsuranceName().equals(insName))
                .findFirst()
                .orElseThrow(() -> new CustomException("해당 정보가 존재하지 않습니다."));
    }

    public ArrayList<Insurance> get(){
        return insuranceList;
    }

}
