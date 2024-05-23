package insurance;

import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

    private ArrayList<Insurance> insuranceList;

    public InsuranceListImpl(ArrayList<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    @Override
    public void add(Insurance insurance){
        insuranceList.add(insurance);
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public Insurance getInsuranceByName(String insName) {
        return insuranceList.stream()
                .filter(insurance -> insurance.getInsuranceName().equals(insName))
                .findFirst()
                .orElse(null);
    }

}