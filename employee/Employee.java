package employee;

import contract.Contract;
import employee.sellingRecord.SellingRecord;
import employee.sellingRecord.SellingRecordListImpl;
import payment.Payment;

public class Employee {

	private String employeeID;
	private String employeeName;
	private String gender;
	private String birth;
	private String position;
	private String address;
	private String incidentDate;
	private String phoneNumber;
	public SellingRecordListImpl sellingRecordList;

	public Employee(String employeeID, String employeeName,String gender, String birth, String phoneNumber, String position,
					String address, String incidentDate) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.incidentDate = incidentDate;
		this.position = position;
		this.gender = gender;
		this.birth = birth;
		this.address = address;

		this.sellingRecordList = new SellingRecordListImpl();
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeID='" + employeeID + '\n' +
				", employeeName='" + employeeName + '\n' +
				", gender='" + gender + '\n' +
				", birth='" + birth + '\n' +
				", position='" + position + '\n' +
				", address='" + address + '\n' +
				", incidentDate='" + incidentDate + '\n' +
				", phoneNumber='" + phoneNumber + '\n' +
				'}';
	}
	public SellingRecordListImpl getSellingRecordList() {
		return sellingRecordList;
	}

	public void setSellingRecordList(SellingRecordListImpl sellingRecordList) {
		this.sellingRecordList = sellingRecordList;
	}

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
		return phoneNumber;
	}

	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.phoneNumber = employeePhoneNumber;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}





}