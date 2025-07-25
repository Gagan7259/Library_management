package com.serv;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		 * String name="Gagan";
		 * 
		 * req.setAttribute("label", name); RequestDispatcher
		 * rq=req.getRequestDispatcher("display.jsp"); rq.forward(req, res);
		 */
		
		/*
		 * List studs=(List) Arrays.asList(new Student(1,"gagan"),new
		 * Student(2,"Manoj"));
		 */		
		
		List<Student> studs=Arrays.asList(new Student(1, "Gagan"),new Student(2, "Manoj"));
		
		req.setAttribute("student", studs);
		RequestDispatcher rq=req.getRequestDispatcher("display.jsp");
		rq.forward(req, res);
		
	}

}
