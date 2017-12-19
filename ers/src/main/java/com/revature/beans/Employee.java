package com.revature.beans;

public class Employee {
	private int empID;
	private String firstName;
	private String lastName;
	private String password;
	private String title;
	
	public Employee(int empID, String firstName, String lastName, String password, String title) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.title = title;
	}

	public Employee() {
		super();
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Employee [id = " + empID + ",  first name = " + firstName + ", last name = " + lastName + ", title = " + title + "]";
	}
}