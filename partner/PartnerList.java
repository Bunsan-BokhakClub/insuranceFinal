package partner;

import java.util.ArrayList;

public interface PartnerList {

	public void add(Partner partner);

	void delete();

	public ArrayList<Partner> get();

	void update();

}