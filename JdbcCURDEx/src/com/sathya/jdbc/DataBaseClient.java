package com.sathya.jdbc;

import java.sql.SQLException;

public class DataBaseClient {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

	 EmployeeDao employeeDao = new EmployeeDao();
		
		int res1=employeeDao.save(new Employee(1003,"Komalatha",1200.00));
		System.out.println("Data inserted Successfully.."+res1);
		
	
		int res2=employeeDao.save(new Employee(1004,"Bhandavi",1180.00));
		System.out.println("Data inserted Successfully.."+res2);
}
}
	
