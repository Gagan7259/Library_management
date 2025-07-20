package com.servletss;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.DbConnection;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String category = req.getParameter("category");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String quary = "insert into books(title,author,category,quantity) values(?,?,?,?)";
		PrintWriter out = res.getWriter();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(quary);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, category);
			ps.setInt(4, quantity);

			int row = ps.executeUpdate();
			if (row > 0) {
				res.sendRedirect("viewBooks.jsp");
			} else {
				res.sendRedirect("addBook.jsp");
			}

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}
}
