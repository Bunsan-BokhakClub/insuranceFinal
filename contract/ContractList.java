package contract;

public interface ContractList {

    void add(Contract contract);

    Contract getContractByNameAndPN(String cusName, String pN);

    Contract getContractByID(int id);


    }
