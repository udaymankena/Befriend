<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ page import = "com.cmpe275.sjsu.blueprint.Profile" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view profile</title>
</head>
<body>
<% Profile profile = (Profile) session.getAttribute("sessionProfile");%>
<br>
<p> Username   : <%= profile.getUsername() %> </p>
<p> First name : <%= profile.getFirstname() %> </p>
<p> Last name  : <%= profile.getLastname() %> </p>
<p> Email      : <%= profile.getEmail() %> </p>
<p> Address    : <%= profile.getAddress() %> </p>
<p> Description: <%= profile.getDescription() %> </p>
</body>
</html>