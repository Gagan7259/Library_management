package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Myservlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		
		out.print("HI");
		
//		ServletContext tx=getServletContext();
//		String str=tx.getInitParameter("phone");
//		System.out.println(str);
		
		ServletConfig cg=getServletConfig();
		String str= cg.getInitParameter("phone");
		System.out.println(str);
	}

}
