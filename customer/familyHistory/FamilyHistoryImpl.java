package customer.familyHistory;

import customer.Customer;
import customer.personalHistory.PersonalHistory;

import java.util.ArrayList;


public class FamilyHistoryImpl implements FamilyHistoryList {

    @Override
    public String toString() {
        String answer = "";
        for (FamilyHistory familyHistory: familyHistoryArrayList) {
            answer += familyHistory.getDiseaseName() + " " + familyHistory.getRelationship() + "\n";
        }
        return answer;
    }

    private ArrayList<FamilyHistory> familyHistoryArrayList;

    public FamilyHistoryImpl() {
        familyHistoryArrayList = new ArrayList<FamilyHistory>();
    }



    @Override
    public void add(FamilyHistory familyHistory) {
        familyHistoryArrayList.add(familyHistory);
    }

}
