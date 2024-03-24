package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public CalculatorServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1=Integer.parseInt(request.getParameter("first"));
   		int num2=Integer.parseInt(request.getParameter("second"));
   		String Operation=request.getParameter("Operation");
   		//process the data
   		int result=0;

   		switch(Operation)
   		{
   		    case "+": result=num1+num2;
   		              break;

   		    case "-": result=num1-num2;
   		              break;

   		    case "*": result=num1*num2;
   		              break;

   		    case "/": result=num1/num2;
   		              break;

   		    case "%": result=num1%num2;
   		              break;
   		}
   		//Render the response
   		response.setContentType("text/html");
   		PrintWriter writer=response.getWriter();
   		writer.println("<html>");
   		writer.println("<body bgcolor=skyblue>");
   		writer.println("<h1>Your result..<h1>");
   		writer.println("<p>FirstNumber:"+num1+"</p>");
   		writer.println("<p>SecondNumber:"+num1+"</p>");
   		writer.println("<p> Selected Operation:"+Operation+"</p>");
   		writer.println("<p>result is:"+result+"</p>");
   		writer.println("</body>");
   		writer.println("</html>");
	}
}


