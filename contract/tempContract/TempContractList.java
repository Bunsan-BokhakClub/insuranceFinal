package contract.tempContract;

import exception.CustomException;

import java.util.ArrayList;

public interface TempContractList {

    void add(TempContract application);

    String getAllTempContract();

    TempContract getInsuranceTempContractById(String id) throws CustomException;
}
