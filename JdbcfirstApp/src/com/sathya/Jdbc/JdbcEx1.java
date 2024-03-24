package com.sathya.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//Step-1:Load the Driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Driver Loaded Succecssfully...");
				
				//step-2:create the connection
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:Xe","nani","welcome");
				System.out.println("Connection created Successfully....");
			
				//step3-Static query execution
			 
				 Statement statement=connection.createStatement();
			     String q1="create table emp(id number,name varchar2(30),Salary number)";
			     int res1= statement.executeUpdate(q1);
			     System.out.println("Table created successfully.."+res1);
				 
//				 String q2="drop table emp";
//				 int res2= statement.executeUpdate(q2);
//				 System.out.println("Table Dropped successfully.."+res2);
//				 
		     	//step4:Release the connection
				connection.close();
					System.out.println("Connection closed successfully...");
			}
			
		     
		}