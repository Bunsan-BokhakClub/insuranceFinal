package contract;

import exception.CustomException;

public interface ContractList {

    void add(Contract contract);

    Contract getContractByID(String id) throws CustomException;


    }
