package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName = (request.getParameter("empName"));
		double EmpBasicSalary = Double.parseDouble(request.getParameter("EmpBasicSalary"));
		

		double hra = 0,da=0,pf=0;
		double Gross_Salary=0;
		
		//step2 Process the data
		if((EmpBasicSalary >=5000) )
		{
			hra=(30*EmpBasicSalary)/100.0;
			da=(10*EmpBasicSalary)/100.0;
			pf=(6*EmpBasicSalary)/100.0;
			Gross_Salary=EmpBasicSalary+hra+da-pf;
			
		}
		else if((EmpBasicSalary >25000) && (EmpBasicSalary <5000) ){
			hra=(20*EmpBasicSalary)/100.0;
			da=(10*EmpBasicSalary)/100.0;
			pf=(3*EmpBasicSalary)/100.0;
			Gross_Salary=EmpBasicSalary+hra+da-pf;
		}
		else if(EmpBasicSalary >2500)
		{
			hra=(20*EmpBasicSalary)/100.0;
			da=(10*EmpBasicSalary)/100.0;
			pf=(3*EmpBasicSalary)/100.0;
			Gross_Salary=EmpBasicSalary+hra+da-pf;
		} 
	


	
		//step3: render the response

	
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		
		writer.println("<h1>BasicSaraly</h1>");
		writer.println("Emp ID : " +empId + "<br><br>");
		writer.println("Emplyoee Name : " +empName + "<br><br>");
		writer.println("Emplyoee basic salary : " +EmpBasicSalary + "<br><br>");
		writer.println("HRA Ammount : " +hra + "<br><br>");
		writer.println("DA ammount : " +da + "<br><br>");
		writer.println("PF ammount : " +pf + "<br><br>");
		writer.println("Gross_salary: " +Gross_Salary + "<br><br>");
		
		writer.println("</body>");
		writer.println("</html>");
	
	}

	//	PrintWriter writer = response.getWriter();
}
