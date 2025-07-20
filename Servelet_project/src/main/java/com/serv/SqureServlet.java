package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/sqr")
public class SqureServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int  k=0;
	Cookie cookies[]=	req.getCookies();
		for(Cookie c:cookies) {
			if(c.getName().equals("k"))
				k=Integer.parseInt(c.getValue());
		}
		
		
//	//using requestdispatcher method	
//		int i=Integer.parseInt( req.getParameter("k"));
//		i*=i;
//		PrintWriter out=res.getWriter();
//		out.println("Hello squre:"+i);
		
		
//		Using sendDirect 
		System.out.println("Sq called");
	}

}
