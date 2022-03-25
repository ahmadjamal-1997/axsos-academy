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
<div class="row">
<div class="col">
<h1>Project Details</h1>
</div>
<div class="col">
<a href="/home" style="margin-left: 100px;margin-top: 20px;">Back to Dashboard</a>
</div>
</div>
<div style="margin-left: 100px;margin-top: 100px">
<div style="display: flex;width: 300px;justify-content: space-between;">
	<p >Project:</p>
	<p>${thisProject.title}</p>
</div>
<div style="display: flex;width: 300px;justify-content: space-between;">
	<p >description</p>
	<p>${thisProject.description}</p>
</div>
<div style="display: flex;width: 300px;justify-content: space-between;">
	<p >Due Date</p>
	<p>${thisProject.dueDate}</p>
</div>
</div>

</body>
</html>