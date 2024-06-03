package contract;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ContractListImpl implements ContractList {



    public ArrayList<Contract> contractList;

    public ContractListImpl() {
        this.contractList = new ArrayList<Contract>();
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
    public Contract getContractByID(String id) {
        for (Contract contract : contractList) {
            if (contract.getContractID().equals(id)) {
                return contract;
            }
        }
        return null;
    }

    public ArrayList<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(ArrayList<Contract> contractList) {
        this.contractList = contractList;
    }
}
