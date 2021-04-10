package com.devops.Inventory;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Home
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  //process Login info
  public Home() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("##### Your Action is initiated #######");
    
     
    
    String responsePage = "index.jsp";
    RequestDispatcher rd = request.getRequestDispatcher(responsePage);
    
    request.getRequestDispatcher("displayData.jsp");
    //Get data
    String email = request.getParameter("email");
    String pwd = request.getParameter("password");
    

    if (Login(email, pwd) == true) {
    	//is successful goto success.jsp
      responsePage = "Welcome.jsp";
      rd = request.getRequestDispatcher(responsePage);
      rd.include(request, response);
    }
    else
    {
      request.setAttribute("dfontcolor", "red");
      //Error message below
      request.setAttribute("dmessage", "Sorry Incorrect UserName or Password!");
      rd.include(request, response);
    }
  }
  //Mongo DB
  public boolean Login(String strEmail, String strPwd){
	 
	    String ip= null;
	  
	    String email = strEmail;
	    String pwd = strPwd;
	    
	  
	    if (email=="a@b.com" && pwd=="pass") {
	    	return true;
	    }
	    else
	    {
	       	return false;
	    }
	}
}


