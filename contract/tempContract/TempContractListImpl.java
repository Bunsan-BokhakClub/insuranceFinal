package contract.tempContract;

import java.util.ArrayList;
import java.util.List;

public class TempContractListImpl {
    private List<TempContract> tempContractList;

    public TempContractListImpl() {
        this.tempContractList = new ArrayList<>();
    }

    public void add(TempContract application) {
        tempContractList.add(application);
    }

    public String getAllApplications() {
        String returnValue = "";
        for (TempContract tempContract : tempContractList)
            returnValue += tempContract.getTempContractID() + " / " + tempContract.getCustomerId() + " / " + tempContract.getInsuranceId() + " / " + tempContract.getDate() + "\n";
        return returnValue;
    }

    public TempContract getInsuranceApplicationById(String id) {
        for (TempContract tempContract : tempContractList) {
            if (tempContract.getTempContractID() == Integer.parseInt(id))
                return tempContract;
        }
        return null;
    }
}

