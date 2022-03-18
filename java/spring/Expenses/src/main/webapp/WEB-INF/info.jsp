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
<div style="margin-left:300px; margin-bottom:20px;">
<h1>Save Travels</h1>
<table class="table" style="width : 500px;">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="expense" items="${expense}">
    <tr>
 
      <td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
      <td><c:out value="${expense.vendor}"></c:out></td>
      <td><c:out value="${expense.amount}"></c:out></td>
      <td><a href="/expenses/${expense.id}/edit">edit</a></td>
      <form:form action="expenses/${expense.id}/delete" method="post">
      <td><button type="submit">Delete</button></td>
      </form:form> 
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
<div style="margin-left: 300px; width : 300px; display:flex;flex-direction:column;  justify-content:flex-start; ">
<h2>Add an expense</h2>
	<form:form action="/expenses/new" method="post" modelAttribute="expenses">
    <p style="display:flex; justify-content:space-between;">
        <form:label path="name">Name</form:label>
        
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