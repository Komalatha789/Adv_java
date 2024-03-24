package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data


		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		//object located
		HttpSession session=request.getSession(false);
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<pre>");
		writer.println("UserName..."+session.getAttribute("username"));
		writer.println("UserAge..."+session.getAttribute("age"));
		writer.println("Userqualification..."+session.getAttribute("qualification"));
		writer.println("Userdesignation..."+session.getAttribute("designation"));
		writer.println("Useremail..."+request.getParameter("email"));
		writer.println("Usermobile..."+request.getParameter("mobile"));
		
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
	}	

}
