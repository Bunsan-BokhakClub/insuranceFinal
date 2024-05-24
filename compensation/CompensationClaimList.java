package compensation;

import java.util.ArrayList;

public interface CompensationClaimList {

	void add(CompensationClaim compensationClaim);

	public void delete();

	public ArrayList<CompensationClaim> get();

	public void update();

}