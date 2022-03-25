<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Language</title>
<style>
body {
	font-family: cursive;
	font-size: 22px;
	margin: 40px 0px 0px 60px;
}
</style>
</head>
<body>
	<h1 style="margin-left: 950px ;font-size: 22px"><a href="#">Delete</a> | <a href="/languages">Dashboard</a></h1>
		<form:form action="/edit/${language.id}" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Name :</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>