<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<form:errors path = "loginObj.*"></form:errors>
<br>

<form action="login" method = "post">
Username: <input type = "text" name = "username"/>
Password: <input type = "password" name = "password"/>
<input type = "submit" value = "submit">

</form>

<br>
<br>
<form action="createprofile" method = "get">
<p>Don't have an account?</p>
<p><input type = "submit" value = "Create Profile"></p> 
</form>
</body>
</html>