<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Language's Details</title>
<style>
body {
	font-family: cursive;
	font-size: 22px;
	margin: 50px 0px 0px 50px;
}
</style>
</head>
<body>
<p style="margin-left: 950px"><a href="/languages">Dashboard</a></p>
<h1> <c:out value="${language.name }"></c:out> </h1>
<p> <c:out value="${language.creator }"></c:out> </p>
<p> <c:out value="${language.currentVersion }"></c:out> </p>
<p><a href="#">Delete</a> | <a href="/languages/edit/${language.id}">Edit</a></p>

</body>
</html>