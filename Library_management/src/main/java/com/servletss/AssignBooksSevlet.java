package com.servletss;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.DbConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AssignBooksSevlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get form data from request
		String userID = req.getParameter("userid");
		String bookID = req.getParameter("bookid");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String assignDate = req.getParameter("assignDate");
		String returnDate = req.getParameter("retunDate");
		String status = req.getParameter("avilable");

		PrintWriter out = resp.getWriter();

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DbConnection.getConnection();

			// Prepare SQL insert statement
			String insert = "INSERT INTO assignbooks (user_id, book_id, title, author, assign_date, return_date, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(insert);
			ps.setString(1, userID);
			ps.setString(2, bookID);
			ps.setString(3, title);
			ps.setString(4, author);
			ps.setString(5, assignDate);
			ps.setString(6, returnDate);
			ps.setString(7, status);

			int rowsAffected = ps.executeUpdate(); // Use executeUpdate here

			if (rowsAffected > 0) {
				resp.sendRedirect("assignBook.jsp"); // Success
			} else {
				out.println("Failed to assign book. Try again.");
			}

		} catch (Exception e) {
			e.printStackTrace(); // Print error to console
			out.println("Error: " + e.getMessage());
		}
	}
}
