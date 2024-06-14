package contract.tempContract;

public class TempContract { //보험 신청 임시 저장소

    private int tempContractID;
    private String customerId;
    private String insuranceId;
    private String date;

    public TempContract(int tempContractID, String customerId, String insuranceId, String date) {
        this.tempContractID = tempContractID;
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
    public int getTempContractID() {
        return tempContractID;
    }

}

