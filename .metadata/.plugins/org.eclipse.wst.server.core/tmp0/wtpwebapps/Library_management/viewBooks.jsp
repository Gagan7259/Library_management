<%@page import="com.connection.DbConnection"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>View Books</title>
<style>
table {
	width: 80%;
	margin: auto;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #999;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

h2 {
	text-align: center;
	margin-top: 30px;
}
</style>
</head>
<body>
	<h2>Books Available</h2>

	<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {

		conn = DbConnection.getConnection();

		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM books");
	%>

	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>AVILABLE</th>
			<th>Category</th>
			<th>Quantity</th>
		</tr>

		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("title")%></td>
			<td><%=rs.getString("author")%></td>
			<td><%=rs.getBoolean("avilable")%></td>
			<td><%=rs.getString("category")%></td>
			<td><%=rs.getInt("quantity")%></td>
		</tr>
		<%
		}
		%>
	</table>

	<%
	} catch (Exception e) {
	out.println("<p style='color:red; text-align:center;'>Error: " + e.getMessage() + "</p>");
	}
	%>

</body>
</html>