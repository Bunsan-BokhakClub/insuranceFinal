package insurance.InsuranceApplication;

import java.util.ArrayList;
import java.util.List;

public class InsuranceApplicationListImpl {
    private List<InsuranceApplication> insuranceApplicationList;

    public InsuranceApplicationListImpl() {
        this.insuranceApplicationList = new ArrayList<>();
    }

    public void add(InsuranceApplication application) {
        insuranceApplicationList.add(application);
    }


    public String getAllApplications() {
        String returnValue = "";
        for (InsuranceApplication insuranceApplication: insuranceApplicationList)
            returnValue += insuranceApplication.getInsuranceApplicationId() + " / " + insuranceApplication.getCustomerId() + " / " + insuranceApplication.getInsuranceId() + " / " + insuranceApplication.getDate() + "\n";
        return returnValue;
    }

    public InsuranceApplication getInsuranceApplicationById(String id) {
        for (InsuranceApplication insuranceApplication: insuranceApplicationList) {
            if (insuranceApplication.getInsuranceApplicationId() == Integer.parseInt(id))
                return insuranceApplication;
        }
        return null;
    }
}

