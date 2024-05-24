package employee.sellingRecord;

import java.util.ArrayList;

public class SellingRecordListImpl implements SellingRecordList{

    private ArrayList<SellingRecord> sellingRecordsList;
    public SellingRecord sellingRecord;

    @Override
    public void add(SellingRecord sellingRecord) {
        sellingRecordsList.add(sellingRecord);
    }

    @Override
    public void delete() {

    }

    @Override
    public ArrayList<SellingRecord> get() {
        return sellingRecordsList;
    }

    @Override
    public void update() {

    }
}