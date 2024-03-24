package com.sathya.servlet;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class Loginform extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String Status;
		if(username.equals("sathya")&&password.equals("sathya@123"))

		{
			Status= "Login successfull";
		}
		else
	
		{
			Status="Login fail";
		}
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>loginstatus...</h1>"+Status);
		writer.println("</html>");
		
		
		
		}
}
		


