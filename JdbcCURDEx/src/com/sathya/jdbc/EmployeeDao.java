package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
	public int save(Employee emp) throws SQLException
	{
		//Declare the Resources
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		try {
			//get the connection
			connection=DbConnection.createConnection();
			
				//create the ps Object
			preparedStatement =connection.prepareStatement("insert into emp values(?,?,?)");
			
			//Read the data from object and set to parameters
			
			preparedStatement.setInt(1, emp.getEmpid());
			preparedStatement.setString(2, emp.getEmpName());
			preparedStatement.setDouble(3, emp.getEmpsalary());
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		finally{
			//before release connect check the connection present or not
		
			if(connection!=null)
				connection.close();
			if(preparedStatement!=null)
				preparedStatement.close();
		}
		return count;
		}
}
