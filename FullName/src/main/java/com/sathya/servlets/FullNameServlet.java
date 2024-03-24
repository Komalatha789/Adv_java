package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FullNameServlet")
public class FullNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	{
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName=request.getParameter("FirstName");
		String MiddleName=request.getParameter("MiddleName");
		String LastName=request.getParameter("LastName");
		String FullName=FirstName+MiddleName+LastName;
		PrintWriter Writer= response.getWriter();
		response.setContentType("text/html");
		Writer.println("<html>");
		Writer.println("<h1>FullName</h1>"+FullName);
		Writer.println("</html>");
		
		
		
	}

	
	}

