<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View friendrequests</title>
</head>
<body>
Your friendrequests
<%String[] friendrequests = (String[])session.getAttribute("friendrequests"); %>

<c:forEach var="i" begin="0" end="1">
<p><c:out value = "${friendrequests[i]}"/> </p>
</c:forEach>
<p></p>
<p>Copy-paste any of the above email address and submit to accept any of the friend requests</p>
<form action="addfriend" method="post">
<p>Add friend by email: <input type="text" name="email"></p>
<p> <input type = "submit" value="Add"></p>
</form>
<%String message_addfriend = (String)session.getAttribute("displayMessage"); %>
<p><%=message_addfriend %></p>
<p>Copy-paste any of the above email address and submit to reject any of the friend requests</p>
<form action="deletefriendrequest" method="post">
<p>Reject friend request by email: <input type="text" name="email"></p>
<p> <input type = "submit" value="Reject"></p>
</form>
<%String message_deletefriendrequest = (String)session.getAttribute("displayMessage"); %>
<p><%=message_deletefriendrequest %></p>
</body>
</html>
