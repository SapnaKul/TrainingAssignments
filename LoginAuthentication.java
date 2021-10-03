package com.cts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginAuthentication")
public class LoginAuthentication extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws 
	ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//get the firstname and lastname form firstpage.html
		
		String un =req.getParameter("userName");
		String pn = req.getParameter("password1");
		if(un.equals("admin")& pn.equals("admin"))
		{ 
			out.println("Login Succesful");
			resp.sendRedirect("/LoginProject/WelcomeServlet");
			
		}
		else {
			out.println("Login unsuccesful");
		}
		out.close();
	}

	
}
