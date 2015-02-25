<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>update your profile here</p>
<form method="post" action="updateprofile">

Password: <input type = "password" name = "password"/>
<br/>
First name: <input type = "text" name = "firstname"/>
<br/>
Last name: <input type = "text" name = "lastname"/>
<br/>
Address: <input type = "text" name = "address"/>
<br/>
Description: <input type = "text" name = "description"/>
<br/>
<input type = "submit" value = "Update"/>
<br/>
</form>
</body>
</html>