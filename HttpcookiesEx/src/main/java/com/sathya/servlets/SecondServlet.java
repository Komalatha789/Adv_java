package com.sathya.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("./SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data requested form data
		String qualification=request.getParameter("qualification");
		String designation=request.getParameter("designation");
		// create the cookie object
		Cookie cookie3=new Cookie("qualification",qualification);
		Cookie cookie4=new Cookie("designation",designation);
		//add the cookies into response object
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		//give to the next client
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form3.html");
		dispatcher.forward(request,response);
}	
	}


