package contract;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ContractListImpl implements ContractList {

    public ArrayList<Contract> contractList;

    public ContractListImpl(ArrayList<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public void add(Contract contract) {
        contractList.add(contract);
    }

    @Override
    public Contract getContractByNameAndPN(String cusName, String pN) {
        return contractList.stream()
                .filter(contract -> contract.getCustomerName().equals(cusName))
                .filter(contract -> contract.getPhoneNumber().equals(pN))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Contract> getContractListByCusName(String cusName) {
        return contractList.stream()
                .filter(contract -> contract.getCustomerName().equalsIgnoreCase(cusName))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public Contract getContractByInsName(String insName) {
        return contractList.stream()
                .filter(contract -> contract.getInsuranceName().equals(insName))
                .findFirst()
                .orElse(null);

    }
    public Contract getContractByID(int id) {
        for (Contract contract : contractList) {
            if (contract.getContractID() == id) {
                return contract;
            }
        }
        return null;
    }
}
