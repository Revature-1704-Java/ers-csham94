package com.revature.ers;

import com.revature.dao.ersDAO;
import com.revature.beans.Employee;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {
    	ersDAO dao = new ersDAO();
    	Scanner scan = new Scanner(System.in);
    	//List<Employee> employees = new ArrayList<>();
    	//System.out.println(employees.get(1));
    	

    	System.out.println("Welcome to the Employee Reimbursement System (ERS).");
    	System.out.println("In order to access the ERS, you must log in.");
		System.out.println("Please enter your Employee ID");
		String login = scan.nextLine();
		System.out.println("Please enter your Password");
		String pass = scan.nextLine();
		
		String result = ersDAO.checkLogin(login, pass);
		System.out.println(result);

		scan.close();
    }
}
