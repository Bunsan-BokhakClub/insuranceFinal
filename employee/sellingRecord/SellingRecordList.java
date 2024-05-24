package employee.sellingRecord;

import java.util.ArrayList;

public interface SellingRecordList {

    public void add(SellingRecord sellingRecord);

    public void delete();

    public ArrayList<SellingRecord> get();

    public void update();
}