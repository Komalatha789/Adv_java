package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.build.AbstractOrigin.InputStreamOrigin;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ProId=request.getParameter("proId");
		String ProName=request.getParameter("proName");
		double ProPrice=Double.parseDouble(request.getParameter("proPrice"));
		String ProBrand=request.getParameter("proBrand");
		String ProMadeIn=request.getParameter("proMadeIn");
		Date ProMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date ProExpDate=Date.valueOf(request.getParameter("proExpDate"));
		Part Part=request.getPart("proImage");
		InputStream inputstream=Part.getInputStream();
		
		//conversion of inputStream to
				byte[] proImage=IOUtils.toByteArray(inputstream);
				Part part1=request.getPart("proAudio");
				Inputstream inputstream1=part1.getInputStream();
				byte[] proAudio=IOUtils.toByteArray(inputstream1);
				Part part2=request.getPart("provideo");
				Inputstream inputstream2=part2.getInputStream();
				byte[] provideo=IOUtils.toByteArray(inputstream2)
;		//using above details create product object
		Product product=new Product();
		product.setProId(ProId);
		product.setProName(ProName);
		product.setProPrice(ProPrice);
		product.setProBrand(ProBrand);
		product.setProMadeIn(ProMadeIn);
		product.setProMfgDate(ProMfgDate);
		product.setProExpDate(ProExpDate);
		product.setProImage(proImage);
		
		//giving the product object to DAO layer
		 ProductDao productDao=new ProductDao();
		 int result=productDao.save(product);
		 
		 if(result==1)
		 {
			 //send data to jsp file add data into request
			 request.setAttribute("saveResult",result);
		 	 RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
		 	 dispatcher.forward(request, response);
		 }
		 else
		 {
			 response.setContentType("text/html");
			 PrintWriter writer=response.getWriter();
			 writer.println("Data insertion fail check once.."+result);
			 RequestDispatcher dispatcher=request.getRequestDispatcher("Addproduct.html");
		 	 dispatcher.include(request, response);
		 }
		
	}
}
