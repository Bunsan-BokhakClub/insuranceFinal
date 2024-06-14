package contract;

import exception.CustomException;

import java.util.ArrayList;

public class ContractListImpl implements ContractList {

    public ArrayList<Contract> contractList;

    public ContractListImpl() {
        this.contractList = new ArrayList<Contract>();
    }

    @Override
    public void add(Contract contract) {
        contractList.add(contract);
    }

    public Contract getContractByID(String id) throws CustomException {
        for (Contract contract : contractList) {
            if (contract.getContractID().equals(id)) {
                return contract;
            }
        }
        throw new CustomException("해당 정보를 찾을 수 없습니다.");
    }


    public ArrayList<Contract> getContractList() {
        return contractList;
    }
}
