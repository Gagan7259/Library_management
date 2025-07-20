<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="Css/style.css">

</head>
<body>

	<form action="RegistrationServlet" method="post">
		Username : <input type="text" name="uname"><br> <br>
		Password:<input type="password" name="pass"><br> <br>
		Role: <select name="role">
			<option value="user">User
			<option />
			<option value="admin">Admin
			<option />
		</select><br> <br>
		<button type="submit" value="rigister">Rigister</button>
	</form>
</body>
</html>