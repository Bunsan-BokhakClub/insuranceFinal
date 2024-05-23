package insurance.InsuranceApplication;

public class InsuranceApplication {
    private String applicationId;
    private String customerId;
    private String insuranceId;
    private boolean isApproved;

    public InsuranceApplication(String applicationId, String customerId, String insuranceId, boolean isApproved) {
        this.applicationId = applicationId;
        this.customerId = customerId;
        this.insuranceId = insuranceId;
        this.isApproved = isApproved;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}

