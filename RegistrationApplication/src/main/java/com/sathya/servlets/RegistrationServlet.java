package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read the Data
		String username=request.getParameter("Username");
		String password=request.getParameter("Password");
		Long mobile=Long.parseLong (request.getParameter("Mobile no"));
		String Email=request.getParameter("Email");
		String gender=request.getParameter("Gender");
		String DOB=request.getParameter("DOB");
		String []quals=request.getParameterValues("Qualification");
		String country=request.getParameter("Country");
		String Languages=request.getParameter("Languages");
		String Comments=request.getParameter("Comments");
	//step 2:process the Request
		String q =String.join(",",quals);
		String l =String.join("-", Languages);
		//step3:render the response
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("your username:"+username+"<br><br>");
		writer.println(" your password:"+password+"<br><br>");
		writer.println(" mobile no:"+mobile+"<br><br>");
		writer.println(" Email:"+Email+"<br><br>");
		writer.println(" gender:"+gender+"<br><br>");
		writer.println(" dob:"+DOB+"<br><br>");
		writer.println("qualification:"+q+"<br><br>");
		writer.println(" country:"+country+"<br><br>");
		writer.println(" languages:"+l+"<br><br>");
		writer.println(" comments:"+Comments+"<br><br>");
		writer.println("</body>");
		writer.println("</html>");
		
		
	}
}


