package com.sathya.jdbcex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
// create table
	public int CreateProductTable() 
	{
		int count=10;
		try(Connection connection=Dbconnection.createConnection();
				Statement statement =connection.createStatement())
        {
	     count=statement.executeUpdate("create table Product(ProId number,ProName varchar2(10),proprice number)");
        }
        catch(SQLException e)
        {
	      e.printStackTrace();
	
        }
        return count;
	}
	//insert into table
	
public int saveProduct(Product product)
{
	int count=0;
	try(Connection connection=Dbconnection.createConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into product values(?,?,?)"))
	{
		preparedStatement.setInt(1,product.getProId());
		preparedStatement.setString(2,product.getProName());
		preparedStatement.setDouble(3,product.getProprice());	
		count=preparedStatement.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return count;
}
//get product details by id
      public  Product getProductById(int id)
       {
          Product product=null;

          try(Connection connection=Dbconnection.createConnection();
        			PreparedStatement preparedStatement=connection.	prepareStatement("select * from product where proid=?"))
        		{
        	  preparedStatement.setInt(1, id);
        	  ResultSet resultset=preparedStatement.executeQuery();
        	  if(resultset.next())
        	  {
        		  product=new Product();
        		  product.setProId(resultset.getInt(1));
        		  product.setProName(resultset.getString(2));
        		  product.setProprice(resultset.getDouble(3));
        	  }
        		}
          catch(SQLException e)
          {
        	  e.printStackTrace();
          }
          return product;
       }
      //get all products
      public List<Product> getALLProducts()
      {
    	 List<Product> products=new ArrayList<Product>();
    	 Product product=null;
    	 try(Connection connection=Dbconnection.createConnection();
    				Statement statement=connection.createStatement())
    	 {
    		 ResultSet resultSet=statement.executeQuery("select * from product");
    		 while(resultSet.next())
    		 {
    			 product=new Product();
    			 product.setProId(resultSet.getInt(1));
    			 product.setProName(resultSet.getString(2));
    			 product.setProprice(resultSet.getDouble(3));
    			 products.add(product);
    		 }
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return  products;
      }
      //update by price 
      public int updateByprice(double price,double increment)
      {
    	  int count=0;
    	  try(Connection connection=Dbconnection.createConnection();
    				PreparedStatement preparedStatement=connection.	prepareStatement("update product set proprice=proprice+? where proprice>?"))
    	  {
    		  preparedStatement.setDouble(1,increment);
    		  preparedStatement.setDouble(2,price);
    	      count=preparedStatement.executeUpdate();
    	  }
    	  catch(SQLException e)
    	  {
    		  e.printStackTrace();
    	  }
    	  return count;
      }
      //delete by id
      public int deletedById(int id)
      {
    	 int count=0;
    	 try(Connection connection=Dbconnection.createConnection();
    			 PreparedStatement preparedStatement=connection.prepareStatement("delete from product where proid=?"))
    	 {
    		 preparedStatement.setInt(1,id);
    		 count=preparedStatement.executeUpdate();
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return count;
      }
      //delete by price
      public int deletedByprice(double price)
      {
    	  int count=0;
    	  try(Connection connection=Dbconnection.createConnection();
     			 PreparedStatement preparedStatement=connection.prepareStatement("delete from product where proprice>?"))
     	 {
    		  preparedStatement.setDouble(1, price);
    		  count=preparedStatement.executeUpdate();
    		  
     	 }
    	  catch(SQLException e)
    	  {
    		  e.printStackTrace();
    	  }
    	  return count;
      }
      //drop table
      public int dropTable()
      {
    	  int count=10;
    	  try(Connection connection=Dbconnection.createConnection();
     			 Statement statement=connection.createStatement())
     	 {
    		 
    		  count=statement.executeUpdate("drop table product");
    		  
     	 }
    	  catch(SQLException e)
    	  {
    		  e.printStackTrace();
    	  }
    	  return count;
      }
}	  
      
    	  
    		
				
				
				
				
				
				
				

