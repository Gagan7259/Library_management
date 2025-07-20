package com.login;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class loginServelet extends HttpServlet{
	
	public void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException {
		
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		
		if("admin".equals(userName) && "123".equals(password)) {
			RequestDispatcher rd=req.getRequestDispatcher("Welcome.jsp");
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("Error.jsp");
			rd.forward(req, res);
		}
		
	}

}
