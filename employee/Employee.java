package employee;

import contract.Contract;
import employee.sellingRecord.SellingRecord;
import payment.Payment;

public class Employee {
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


	private String employeeID;

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}

	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}

	public String getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public SellingRecord getSellingRecord() {
		return sellingRecord;
	}

	public void setSellingRecord(SellingRecord sellingRecord) {
		this.sellingRecord = sellingRecord;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	private String employeeName;
	private String employeePhoneNumber;
	private String incidentDate;
	private String position;
	public SellingRecord sellingRecord;
	public Contract contract;
	public Payment payment;



}