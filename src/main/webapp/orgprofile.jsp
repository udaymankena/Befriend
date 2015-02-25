<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><a href="vieworganization.jsp">View profile</a></p>
<p><a href="updateorganization.jsp">UpdateProfile</a></p>


<form action="orgcreatepost" method="post">
<p>Make a post: <input type = "text" name="message"></p>
<p><input type = "submit"></p>
</form>

<form action="orgviewposts" method="get">
<p>View your posts<input type = "submit" value="View"></p>
</form>



</body>
</html>