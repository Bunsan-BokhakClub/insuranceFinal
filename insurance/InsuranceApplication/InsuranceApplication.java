package insurance.InsuranceApplication;

public class InsuranceApplication { //보험 신청 임시 저장소

    private int insuranceApplicationId;
    private String customerId;
    private String insuranceId;



    private String date;
    public InsuranceApplication(int insuranceApplicationId, String customerId, String insuranceId, String date) {
        this.insuranceApplicationId = insuranceApplicationId;
        this.customerId = customerId;
        this.insuranceId = insuranceId;
        this.date = date;
    }


    public String getCustomerId() {
        return customerId;
    }

    public String getInsuranceId() {
        return insuranceId;
    }
    public String getDate() {
        return date;
    }
    public int getInsuranceApplicationId() {
        return insuranceApplicationId;
    }

    public void setInsuranceApplicationId(int insuranceApplicationId) {
        this.insuranceApplicationId = insuranceApplicationId;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

