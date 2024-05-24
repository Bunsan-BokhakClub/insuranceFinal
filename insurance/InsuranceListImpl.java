package insurance;

import java.util.ArrayList;
import java.util.List;

public class InsuranceListImpl implements InsuranceList {

    private ArrayList<Insurance> insuranceList;
    public Insurance m_Insurance;

    public InsuranceListImpl(ArrayList<Insurance> insList) {
        this.insuranceList = insList;
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

    @Override
    public List<Insurance> getListByUserId(String customerID) {
        List<Insurance> customerInsurances = new ArrayList<>();
        for (Insurance insurance : insuranceList) {
            if (insurance.getCustomerIDs().contains(customerID)) {
                customerInsurances.add(insurance);
            }
        }
        return customerInsurances;
    }

    @Override
    public void update(Insurance insurance) {
        for (int i = 0; i < insuranceList.size(); i++) {
            if (insuranceList.get(i).getInsuranceID().equals(insurance.getInsuranceID())) {
                insuranceList.set(i, insurance);
                break;
            }
        }
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
