package employee;

import java.util.ArrayList;

public class EmployeeListImpl implements EmployeeList {

	private ArrayList<Employee> employeeList;
	public Employee employee;

	public EmployeeListImpl(ArrayList<Employee> employeeList){
		this.employeeList = employeeList;
	}

	public void add(){

	}

	public void delete(){

	}

	public ArrayList<Employee> get(){
		return employeeList;
	}

	public Employee getEmployeeByID(String id) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeID().equals(id)) {
				return employee;
			}
		}
		return null;
	}

	public void update(){

	}

}