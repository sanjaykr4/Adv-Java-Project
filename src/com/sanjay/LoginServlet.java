package com.sanjay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		String Name=request.getParameter("UserID");
		String Password=request.getParameter("Password");
		
		
		if(Name.equals("admin") && Password.equals("admin")) 
		{
			
			request.getRequestDispatcher("AdminWelcome.html").include(request, response);
			
		}
		else 
		{
		out.println("<h2 style=\"text-align: center;\">Password Incorrect Please Login Again</h2>");
		request.getRequestDispatcher("LoginPage.html").include(request, response);
		}
		
	}

}
