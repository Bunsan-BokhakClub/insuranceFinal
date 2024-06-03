package partner.rate;

import insurance.Insurance;

import java.util.ArrayList;

public class RateListImpl implements RateList{
    public ArrayList<Rate> getRateList() {
        return RateList;
    }

    private ArrayList<Rate> RateList;

    public RateListImpl() {
        this.RateList = new ArrayList<Rate>();
    }
    @Override
    public void add(Rate rate) {
        this.RateList.add(rate);
    }

}
