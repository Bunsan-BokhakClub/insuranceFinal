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

	public Employee(String employeeID, String employeeName, String employeePhoneNumber, String incidentDate, String position, SellingRecord sellingRecord, Contract contract, Payment payment) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeePhoneNumber = employeePhoneNumber;
		this.incidentDate = incidentDate;
		this.position = position;
		this.sellingRecord = sellingRecord;
		this.contract = contract;
		this.payment = payment;
	}

}