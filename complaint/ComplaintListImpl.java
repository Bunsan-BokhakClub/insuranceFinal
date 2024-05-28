package complaint;
import java.util.ArrayList;
public class ComplaintListImpl implements complaintList {
	private ArrayList<Complaint> complaintList;


	public ComplaintListImpl(){
		this.complaintList = new ArrayList<Complaint>();
	}


	public void add(Complaint complaint){
		complaintList.add(complaint);
	}

	public void delete(){
	}
	public String getComplaintByID(){
		return "";
	}
	public void get(){
	}
	public void update(){
	}

	}