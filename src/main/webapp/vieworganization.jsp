<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cmpe275.sjsu.blueprint.Organization" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Organization profile</title>
</head>
<body>
<%Organization organization = (Organization)session.getAttribute("sessionOrganization"); %>

<p>Organization name:<%=organization.getName() %></p>
<p>Description      :<%=organization.getDescription() %></p>
<p>Address          :<%=organization.getAddress()%></p>
<p>Email            :<%= organization.getEmail() %></p>
<p>Phone            :<%=organization.getPhone() %></p>
<p>Website          :<%=organization.getWebsite() %></p>
 
</body>
</html>