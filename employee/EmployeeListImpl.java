package employee;

import java.util.ArrayList;

public class EmployeeListImpl implements EmployeeList {

	private ArrayList<Employee> employeeList;

	public EmployeeListImpl(){
		this.employeeList = new ArrayList<Employee>();
	}

	public void add(Employee employee){
		employeeList.add(employee);
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