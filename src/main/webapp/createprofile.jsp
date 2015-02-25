<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Profile</title>
</head>
<body>
<form method="post" action="createprofile">
Username: <input type = "text" name = "username"/>
<br/>
Password: <input type = "password" name = "password"/>
<br/>
First name: <input type = "text" name = "firstname"/>
<br/>
Last name: <input type = "text" name = "lastname"/>
<br/>
Email: <input type = "text" name = "email"/>
<br/>
Address: <input type = "text" name = "address"/>
<br/>
Description: <input type = "text" name = "description"/>
<br/>
<input type = "submit" value = "Create"/>
<br/>
</form>
</body>
</html>