package project.contract;

import project.compensation.CompensationClaim;

public class Contract {

	private String adress;
	private int age;
	private String birth;
	private int compensationAmount;
	private String concludeDate;
	private String customerID;
	private String customerName;
	private String customerStatus;
	private String cycleType;
	private String email;
	private String employeeID;
	private String employeeName;
	private String gender;
	private String insuranceID;
	private String insuranceName;
	private int paymentAmount;
	private int paymentCycle;
	private String phoneNumber;
	public CompensationClaim m_CompensationClaim;

	public Contract(){

	}

	public int calculateCompensationAmount(){
		return 0;
	}

	public int calculateInsuaranceFee(){
		return 0;
	}

}