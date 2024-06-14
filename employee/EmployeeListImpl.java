package employee;

import exception.CustomException;

import java.util.ArrayList;

public class EmployeeListImpl implements EmployeeList {

	private ArrayList<Employee> employeeList;

	public EmployeeListImpl(){
		this.employeeList = new ArrayList<Employee>();
	}

	public void add(Employee employee){
		employeeList.add(employee);
	}

	public ArrayList<Employee> get(){
		return employeeList;
	}

	public Employee getEmployeeByID(String id) throws CustomException {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeID().equals(id)) {
				return employee;
			}
		}
		throw new CustomException("해당 정보가 존재하지 않습니다.");
	}
}