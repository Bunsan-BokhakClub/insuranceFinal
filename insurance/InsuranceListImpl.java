package insurance;

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
    public Insurance getInsuranceByID(String insuranceID) {
        for (Insurance insurance : insuranceList) {
            if (insurance.getInsuranceID().equals(insuranceID)) {
                return insurance;
            }
        }
        return null;
    }


//     public InsuranceListImpl(ArrayList<Insurance> insuranceList) {
//         this.insuranceList = insuranceList;
//     }


    public Insurance getInsuranceByName(String insName) {
        return insuranceList.stream()
                .filter(insurance -> insurance.getInsuranceName().equals(insName))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Insurance> get(){
        return insuranceList;
    }
}
