package com.serv;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class AddServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i=Integer.parseInt(req.getParameter("n1"));
		int j=Integer.parseInt(req.getParameter("n2"));
		int k=i+j;
		
//		USING REQUEST DESPACHER
//		k=k*k;	
//		req.setAttribute("k", k);
//		RequestDispatcher rd=req.getRequestDispatcher("sqr");
//		rd.forward(req, res);
		
		res.sendRedirect("sqr");   //url rewriting
		
		Cookie cookie=new Cookie("k",k+"");
		res.addCookie(cookie);
		
		//System.out.println("result is :"+ k);
		//PrintWriter out=res.getWriter();
		//out.println("Result is :"+k);
	}

}
