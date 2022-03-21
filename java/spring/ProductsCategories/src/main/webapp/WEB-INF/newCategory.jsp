<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>New Product</h1>
<form:form action="/categories/new" method="post" modelAttribute="category" style="width:400px;">
    <p style="display:flex; justify-content:space-between;">
        <form:label path="name">Name</form:label>
        <form:input type="text" path="name"/>
        <form:errors path="name"/>
    </p>
    <button type="submit">Create</button>
	</form:form>  
</body>
</html>