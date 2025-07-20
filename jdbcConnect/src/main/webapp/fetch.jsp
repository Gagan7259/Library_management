	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8" import="java.sql.*"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Get Data From JDBC</title>
	</head>
	<body>
	
	<%
	String url="jdbc:mysql://localhost:3306/hospital";
	String username="root";
	String pass="gagan@12";
	String sql="select * from docters where id=1";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url, username,pass);
	Statement st=con.createStatement();
	
	ResultSet rs=st.executeQuery(sql);
	rs.next();
	%>
	
	Docter id:<%=rs.getString(1) %>
		Docter name:<%=rs.getString(2) %>
		Docter Specialization:<%=rs.getString(3) %>
	
	</body>
	</html>