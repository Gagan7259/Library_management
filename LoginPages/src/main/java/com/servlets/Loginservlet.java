package com.servlets;

import java.io.IOException;
import java.rmi.ServerException;

import com.login.dao.LoginDao;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServerException, IOException {
		String uname = req.getParameter("uname");
		String pswd = req.getParameter("password");
LoginDao dso=new LoginDao();
		/*if (uname.equals("Gagan") && pswd.equals("hello")) {*/
		try {
			if (dso.check(uname, pswd)) {
				HttpSession session = req.getSession();
				session.setAttribute("username", uname);

				res.sendRedirect("welcome.jsp");
			} else {
				res.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
