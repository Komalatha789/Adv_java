package com.sathya.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GenerateServlet")
public class GenerateServlet<PrintWriter> extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response, Object e) throws ServletException, IOException {

  // step1: get the data from client
		
		int f=Integer.parseInt( request.getParameter("F"));
		int s=Integer.parseInt( request.getParameter("S"));
    String opp=request.getParameter("OPERTATION");
	     
	     //  step2 : process the data
    
             StringBuffer a=new StringBuffer();
             ArrayList<Integer> e1=new ArrayList<Integer>();

                   int i;
             switch(opp) {
	           
	           
	           case "even":  
	        	               for(i=f;i<=s;i++)
	        	               {
	        	            	    if(i%2==0)
	        	            	    {
	        	            	    	a=a.append(i+" ");
	        	            	    	 e1.add(i);
	        	            	    }
	        	            	    		
	        	               }
	        	               break;
	                           

	           case "odd":  for(i=f;i<=s;i++)
                                {
           	                       if(i%2!=0)
           	                          {
           	                            	a=a.append(i+" ");
           	                                	e1.add(i);
           	                            }
           	    		
                                 }
                                 break;
              
	                       

	                        
                                 
	           case "prime":    
	        	               for(i=f;i<=s;i++)
                               {
	        	            	   int count=0;
	        	                  for(int j=2;j<=i/2;j++)
	        	                  {
	        	                	    if(i%j==0)
	        	                	    {
	        	                	    	count=1;
	        	                	    	break;
	        	                	    }
	        	                	  
	        	                  }
	        	                    if(count==0)
	        	                    {
	        	                     	a=a.append(i+" ");
   	                                	e1.add(i);
   	                           
	        	                    	
	        	                    }
                               }
  	                  
	                        break;
	                        

	           case "perfect": for(i=f;i<=s;i++)
                           {
            	                int sum=0;
                            for(int j=1;j<=i/2;j++)
                                  {
                	                  if(i%j==0)
                	                     {
                	                      	sum=sum+j;
                	    	                   
                	                      }
                	  
                                  }
                              if(sum==i)
                                    {
                                     a=a.append(i+" ");
                                  	e1.add(i);
                  
                    	
                                      }
                              }
        
	                        break;

	           case "Strong":  
	        	      int k;
	        	      int fact,sum,temp,rem;
	        	    for( k=f;k<=s;k++)
	        	    {
	        	    	       temp=k;
	        	              
	        	                sum=0;
	        	                
	        	      for( ;temp>0;temp=temp/10)

                         {
                             rem=temp%10;
                       
                               if(rem==0)
                                 fact=1;
                             else
                                 {    
                            	       fact=1;
                                    for(i =1;i<=rem;i++)
                                       {
                                           fact=fact*i;
                                 
                                         }
                                 }
                                    sum=sum+fact;
                            }
                         if(sum==k)
                         {
                             a=a.append(k+" ");
                               e1.add(k);
                         }
	        	    }

                    
                           break;
	           
	           
	           
	        	    
             }

	 // Render the response to the client
   	      
             response.setContentType("text/html");
	         
	           java.io.PrintWriter writer=response.getWriter();
	            writer.println(" <html>");
	            writer.println("<body bgcolor='pink'> ");
	              writer.println("<h1>calculation details.......</h1>");

	              writer.println("the result is:"+e1);
	              writer.println("</body>");
	              writer.println("</html>");
	}
}
	                
	
