package com.login.dao;

import java.sql.*;

public class LoginDao {

	String url = "jdbc:mysql://localhost:3306/mydb";
	String username = "root";
	String password = "gagan@12";
	String query = "select * from mydb where username=? and pass=?";

	public boolean check(String username, String pass) throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, pass);
			
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
