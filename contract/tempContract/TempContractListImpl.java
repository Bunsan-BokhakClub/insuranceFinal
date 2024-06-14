package contract.tempContract;

import exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class TempContractListImpl implements TempContractList {
    private List<TempContract> tempContractList;

    public TempContractListImpl() {
        this.tempContractList = new ArrayList<>();
    }

    public void add(TempContract application) {
        tempContractList.add(application);
    }

    public String getAllTempContract() {
        String returnValue = "";
        for (TempContract tempContract : tempContractList)
            returnValue += "계약  ID = " + tempContract.getTempContractID() + "\n" +
                    "신청 고객 ID = " + tempContract.getCustomerId() + "\n" +
                    "보험 ID = " + tempContract.getInsuranceId() + "\n" +
                    "신청 일자 = " + tempContract.getDate() + "\n\n";
        return returnValue;
    }

    public TempContract getInsuranceTempContractById(String id) throws CustomException {
        for (TempContract tempContract : tempContractList) {
            if (tempContract.getTempContractID() == Integer.parseInt(id))
                return tempContract;
        }
        throw new CustomException("해당 정보가 존재하지 않습니다.");
    }
}

