package employee;

import contract.Contract;
import employee.sellingRecord.SellingRecord;
import payment.Payment;

public class Employee {

	private String employeeID;
	private String employeeName;
	private String employeePhoneNumber;
	private String incidentDate;
	private String position;
	public SellingRecord sellingRecord;
	public Contract contract;
	public Payment payment;

	public Employee(){

	}

	public void addSellingRecord(){

	}

	public String getEmployeeName(){
		return "";
	}

	public String getEmployeePhoneNumber(){
		return "";
	}

	public void updateEmployeeName(){

	}

	public void updateEmployeePhoneNumber(){

	}

	public void updatePosition(){

	}

}