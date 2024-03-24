package com.sathya.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sathya.servlet.Dbconnection;
import com.sathya.servlet.Product;

public class ProductDao {
	//insert into table
		
	public int save(Product product)
	{

		 Connection connection=null;
		  PreparedStatement preparedStatement=null;
		int count=0;
		try(Connection connection1=Dbconnection.createConnection();
			PreparedStatement preparedStatement1=connection1.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?)"))
		{
			preparedStatement1.setString(1,product.getProId());
			preparedStatement1.setString(2,product.getProName());
			
			preparedStatement1.setDouble(3,product.getProPrice());
			preparedStatement1.setString(4,product.getProBrand());
			preparedStatement1.setString(5,product.getProMadeIn());
			
			preparedStatement1.setDate(6, (Date) product.getProMfgDate());
			preparedStatement1.setDate(7, (Date) product.getProExpDate());
			
			preparedStatement1.setBytes(8,product.getProImage());			
			count=preparedStatement1.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			  //before release connection check the connection present or not
			  try{
				  
			     if(connection!=null)
				  connection.close();
			     if(preparedStatement!=null)
					  preparedStatement.close();
		        }
			  catch(SQLException e) {
				  e.printStackTrace();
			  }
		  }
		return count;
	}
	public List<Product> findAll() {
		
		// Create the list to store group of records
	    List<Product> productList=new ArrayList<Product>();
	    try(Connection connection =Dbconnection.createConnection();
	    	Statement statement =connection.createStatement();	){
	    	//execute the query to store the resultSet                                                                                
	    	ResultSet resultSet=statement.executeQuery("select * from product_data");
	    	while(resultSet.next()) {
	    		Product product=new Product();
	    		  product.setProId(resultSet.getString(1));
	    		  product.setProName(resultSet.getString(2));
	    		  product.setProPrice(resultSet.getDouble(3));
	    		  product.setProBrand(resultSet.getString(4));
	    		  product.setProMadeIn(resultSet.getString(5));
	    		  product.setProMfgDate(resultSet.getDate(6));
	    		  product.setProExpDate(resultSet.getDate(7));
	    		 product.setProImage(resultSet.getBytes(8));
	    		 
	    		  productList.add(product);
	    	
	    	}
	    }
	    	catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    
	    		
	    		return productList;
	    }
	//delete by id
	public int deletedById(String proId)
	{
		int count=0;
		try(Connection connection1=Dbconnection.createConnection();
		PreparedStatement preparedStatement1=connection1.prepareStatement("delete from product_data where proId=?"))
		{

			preparedStatement1.setString(1,proId);			
			count=preparedStatement1.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
		}
	//get product find by id
    public  Product ProductfindById(String id)
     {
        Product product=null;

        try(Connection connection=Dbconnection.createConnection();
      			PreparedStatement preparedStatement=connection.	prepareStatement("select * from product where proid=?"))
      		{
      	  preparedStatement.setString(1, id);
      	  ResultSet resultset=preparedStatement.executeQuery();
      	  if(resultset.next())
      	  {
      		  product=new Product();
      		  product.setProId(resultset.getString("proId"));
      		  product.setProName(resultset.getString("proName"));
      		  product.setProPrice(resultset.getDouble("proPrice"));
      		 product.setProBrand(resultset.getString("proBrand"));
      		 product.setProMadeIn(resultset.getString("proMadeIn"));
      		 product.setProMfgDate(resultset.getDate("proMfgDate"));
      		 product.setProExpDate(resultset.getDate("proExpDate"));
      		 product.setProImage(resultset.getBytes("proImage"));
      	  }
      		}
        catch(SQLException e)
        {
      	  e.printStackTrace();
        }
        return product;
     }
    //updateby id
    public int updateById(Product product)
	{
		int updateCount=0;
		try(Connection connection=Dbconnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("update product_data set proName=?, proPrice=?, proBrand=?, proMadeIn=?, proMfgDate=?, proExpDate=?, proImage=?, proAudio=?, proVideo=? where proId=?"))
		{
			preparedStatement.setString(1,product.getProName());
			preparedStatement.setDouble(2,product.getProPrice());
			preparedStatement.setString(3,product.getProBrand());
			preparedStatement.setString(4,product.getProMadeIn());
			preparedStatement.setDate(5,product.getProMfgDate());
			preparedStatement.setDate(6,product.getProExpDate());
			preparedStatement.setBytes(7,product.getProImage());
			preparedStatement.setBytes(8,product.getProAudio());
			preparedStatement.setBytes(9,product.getProVideo());
			preparedStatement.setString(10,product.getProId());
			
			updateCount=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return updateCount;
	}
}
	
	

	
	
