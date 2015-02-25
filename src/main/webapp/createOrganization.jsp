<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Organization</title>
</head>
<body>
<form method="post" action="createorganization">
Organization Name <input type = "text" name = "name"/>
<br/>
Password          <input type = "password" name = "password"/>
<br/>
Description       <input type = "text" name = "description"/>
<br/>
Address           <input type = "text" name = "address"/>
<br/>
Phone             <input type = "text" name = "phone"/>
<br/>
Email             <input type = "text" name = "email"/>
<br/>
Website           <input type = "text" name = "website"/>
<br/>

<input type = "submit" value = "Create"/>
<br/>
</form>
</body>
</html>