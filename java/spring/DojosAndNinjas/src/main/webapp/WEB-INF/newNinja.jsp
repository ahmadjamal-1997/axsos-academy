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
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja" style="width:400px;">
    <p style="display:flex; justify-content:space-between;">
        <form:label path="dojo">Dojo:</form:label>
		<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}" >
				<form:option value="${dojo.id}">
					<c:out value="${dojo.name}" /> 
				</form:option>
			</c:forEach>
		</form:select>
		</p>
		<p style="display:flex; justify-content:space-between;">
        <form:label path="firstName">First name</form:label>
        <form:input type="text" path="firstName"/>
        <form:errors path="firstName"/>
    	</p>
    	<p style="display:flex; justify-content:space-between;">
        <form:label path="lastName">Last Name</form:label>
        <form:input type="text" path="lastName"/>
        <form:errors path="lastName"/>
    	</p>
    	<p style="display:flex; justify-content:space-between;">
        <form:label path="age">Age</form:label>
        <form:input type="text" path="age"/>
        <form:errors path="age"/>
    	</p>
    <button type="submit">Create</button>
	</form:form> 
</body>
</html>