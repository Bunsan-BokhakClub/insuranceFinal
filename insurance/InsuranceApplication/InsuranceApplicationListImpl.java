package insurance.InsuranceApplication;

import java.util.ArrayList;
import java.util.List;

public class InsuranceApplicationListImpl {
    private List<InsuranceApplication> insuranceApplications;

    public InsuranceApplicationListImpl() {
        this.insuranceApplications = new ArrayList<>();
    }

    public void add(InsuranceApplication application) {
        insuranceApplications.add(application);
    }

    public InsuranceApplication getInsuranceApplicationById(String applicationId) {
        for (InsuranceApplication application : insuranceApplications) {
            if (application.getApplicationId().equals(applicationId)) {
                return application;
            }
        }
        return null;
    }

    public List<InsuranceApplication> getAllApplications() {
        return insuranceApplications;
    }
}

