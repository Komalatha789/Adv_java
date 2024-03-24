package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("./ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		int mobile=Integer.parseInt(request.getParameter("mobile"));
		//Display the total details 
		//total 6=request(2)+cookies(4)
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		Cookie[] cookies=request.getCookies();
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<pre style='color:Green'>");
		writer.println("username:"+cookies[0].getValue()+"<br>");
		writer.println("User age:"+cookies[1].getValue()+"<br>");
		writer.println("User qualification:"+cookies[2].getValue()+"<br>");
		writer.println("User designation:"+cookies[3].getValue()+"<br>");
		writer.println("User email:" +request.getParameter("email")+"<br>");
		writer.println("mobile:"+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
