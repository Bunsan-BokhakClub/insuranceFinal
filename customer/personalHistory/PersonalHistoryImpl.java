package customer.personalHistory;

import customer.Customer;
import customer.familyHistory.FamilyHistory;

import java.util.ArrayList;


public class PersonalHistoryImpl implements PersonalHistoryList {

    private ArrayList<PersonalHistory> personalHistoryArrayList;

    public PersonalHistoryImpl() {
        personalHistoryArrayList = new ArrayList<PersonalHistory>();
    }

    public String toString() {
        String answer = "";
        for (PersonalHistory personalHistory: personalHistoryArrayList) {
            answer += personalHistory.gertDiseaseName() + " " + personalHistory.getOccurDate() + "\n";
        }
        return answer;
    }

    @Override
    public void add(PersonalHistory personalHistory) {
        personalHistoryArrayList.add(personalHistory);
    }

}
