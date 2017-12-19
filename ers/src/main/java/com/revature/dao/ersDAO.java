package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ersDAO {
	public static List<Employee> getAllEmployees() {
		PreparedStatement ps = null;
		Employee e = null;
		List<Employee> employees = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ems_user.EMPLOYEE";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int empID = rs.getInt("EmployeeID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String password = rs.getString("EmpPassword");
				String title = rs.getString("Title");
				
				e = new Employee(empID, firstName, lastName, password, title);
				employees.add(e);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return employees;
	}
	
	public static List<Reimbursement> getAllReimbursements() {
		PreparedStatement ps = null;
		Reimbursement r = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ems_user.REIMBURSEMENT";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reID = rs.getInt("ReimbursementID");
				String desc = rs.getString("Description");
				double cost = rs.getDouble("CostTotal");
				String status = rs.getString("Status");
				int empID = rs.getInt("EmployeeID");
				
				r = new Reimbursement(reID, desc, cost, status, empID);
				reimbursements.add(r);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return reimbursements;
	}
	
	public static Employee getEmployee(int id) {
		List<Employee> employees = getAllEmployees();
		Employee e = new Employee();
		for (Employee employee : employees) {
			int empID = employee.getEmpID();
			if (empID != id) {
				e = employee;
			}
		}
		return e;
	}
	
	public static String checkLogin(String login, String password) {
    	String result;
    	int intLogin = Integer.parseInt(login);
    	Employee check = getEmployee(intLogin);
    	if (check.getPassword().equals(password)) {
    		result = check.getTitle();
    	} else {
    		result = "Invalid ID/password combination";
    	}
  
    	return result;
    }
}