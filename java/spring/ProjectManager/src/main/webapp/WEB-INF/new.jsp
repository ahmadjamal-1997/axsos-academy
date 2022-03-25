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
<h1>Create a new project</h1>

<form:form action="/project/create" method="post" modelAttribute="projects" style="width:400px;">
    <p style="display:flex; justify-content:space-between;">
        <form:label path="title">Project Title</form:label>
        <form:input type="text" path="title"/>
        <form:errors path="title"/>
    </p>
    <p style="display:flex; justify-content:space-between;">
        <form:label path="description">Project Description</form:label>
        <form:errors path="description"/>
        <form:input type="text" path="description"/>
    </p>
    <p style="display:flex; justify-content:space-between;">
        <form:label path="dueDate">Due Date</form:label>
        <form:errors path="dueDate"/>
        <form:input type="date" path="dueDate"/>
    </p>    
    <div>
    <button type="submit">Submit</button>
    
	</div>
	</form:form> 
	<a href="/home"><button>Cancel</button></a> 
</body>
</html>