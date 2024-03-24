package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("ProductServlet")
public class ProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 
		int ProID=Integer.parseInt(request.getParameter("ProID"));
		String ProName = (request.getParameter("ProName"));
		double ProPrice = Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity = Integer.parseInt(request.getParameter("ProductQuantity"));

		double totalbill = (ProPrice * proQuantity);
		double discount;
		//step2 Process the data
		if((totalbill > 1000) && (totalbill <= 5000))
		{
			
			discount = 0.05;
		}
		else if((totalbill > 5000) && (totalbill <= 10000) ){
			discount = 0.10;
		}
		else if(totalbill >= 10000)
		{
			discount=0.15;
		} 
		else
		{
			discount= 0;
		}


		double totalDiscount = (totalbill * discount) ;
		double netamount = (totalbill-totalDiscount);
		//step3: render the response

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		
		
		writer.println("Product ID : " +ProID + "<br><br>");
		writer.println("Product Name : " +ProName + "<br><br>");
		writer.println("Product Price : " +ProPrice + "<br><br>");
		writer.println("Product Quantity : " +proQuantity + "<br><br>");
		writer.println("Product totalbill : " +totalbill + "<br><br>");
		writer.println("Product Discount : " +totalDiscount + "<br><br>");
		writer.println("Product NetAmount : " +netamount + "<br><br>");
		
		writer.println("</body>");
		writer.println("</html>");
			
	}
}

