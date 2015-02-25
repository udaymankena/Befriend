<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View friends</title>
</head>
<body>
Your friends
<%String[] friends = (String[])session.getAttribute("friends"); %>

<c:forEach var="i" begin="0" end="">
<p><c:out value = "${friends[i]}"/> </p>

</c:forEach>


</body>
</html>