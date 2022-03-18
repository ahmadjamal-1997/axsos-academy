<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="margin-left: 300px; width : 300px; display:flex;flex-direction:column;  justify-content:flex-start; ">
<h2>Edit an expense</h2>
	<form:form action="/expenses/update/${expenses.id}" method="post" modelAttribute="expensess">
	<input type="hidden" name="_method" value="put">
    <p style="display:flex; justify-content:space-between;">
        <form:label path="name">Expense Name</form:label>
        
        <form:input type="text" path="name"/>
        <form:errors path="name"/>
    </p>
    <p style="display:flex; justify-content:space-between;">
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input type="text" path="vendor"/>
    </p>
    <p style="display:flex; justify-content:space-between;">
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/>
    </p>
    <p style="display:flex; justify-content:space-between;">
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:input type="text" path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
	</form:form>  
	</div>
</body>
</html>