package customer.familyHistory;

import customer.Customer;

import java.util.ArrayList;


public class FamilyHistoryImpl implements FamilyHistoryList {

    @Override
    public String toString() {
        String answer = "";
        for (FamilyHistory familyHistory: familyHistoryArrayList) {
            answer += familyHistory.getDiseaseName() + " " + familyHistory.getOccurDate() + "\n";
        }
        return answer;
    }

    private ArrayList<FamilyHistory> familyHistoryArrayList;

    public FamilyHistoryImpl() {
        familyHistoryArrayList = new ArrayList<FamilyHistory>();
    }



    @Override
    public void add(FamilyHistory familyHistory) {

    }

}
