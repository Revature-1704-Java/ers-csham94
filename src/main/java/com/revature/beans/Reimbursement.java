package com.revature.beans;

public class Reimbursement {
	private int reID;
	private String description;
	private double total;
	private String status;
	private int empID;
	
	public Reimbursement(int reID, String description, double total, String status, int empID) {
		super();
		this.reID = reID;
		this.description = description;
		this.total = total;
		this.status = status;
		this.empID = empID;
	}

	public Reimbursement() {
		super();
	}

	public int getReID() {
		return reID;
	}

	public void setReID(int reID) {
		this.reID = reID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [id = " + reID + ", description = " + description + ", total = " + total + ", status = " + status + ", employee id = " + empID + "]";
	}
}