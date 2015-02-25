<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><a href="viewprofile.jsp">View profile</a></p>
<p><a href="updateprofile.jsp">UpdateProfile</a></p>

<form action="viewfriends" method="get">
<p>view friends:<input type = "submit" value="view"></p>
</form>

<form action="addfriendrequest" method="post">
<p>Send friend request by email: <input type="text" name="email"></p>
<p> <input type = "submit" value="Add"></p>
</form>
<%String message = (String)session.getAttribute("displayMessage"); %>
<%=message %>

<form action="viewfriendrequests" method="get">
<p>View your friend requests:<input type = "submit" value="view"></p>
</form>


<form action="deletefriend" method="post">
<p>Delete friend by email: <input type="text" name="email"></p>
<p> <input type = "submit" value="Delete"></p>
</form>

<form action="createpost" method="post">
<p>Make a post: <input type = "text" name="message"></p>
<p><input type = "submit"></p>
</form>

<form action="viewposts" method="get">
<p>View your posts<input type = "submit" value="View"></p>
</form>

<form action="viewfriendposts" method="get">
<p>View posts of friends <input type="text" name="email">
<p><input type = "submit" value="View"></p>
</form>

</body>
</html>