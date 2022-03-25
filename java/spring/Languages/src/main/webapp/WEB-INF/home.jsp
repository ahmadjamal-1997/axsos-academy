<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<table class="table table-striped mx-5" style="width: 900px">
  <thead>
  
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">Version</th>
      <th scope="col">Action</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  	
  	<c:forEach var = "language" items = "${language }">
    <tr>
      <th scope="row"><a href="/languages/${language.id }"><c:out value="${language.name }"></c:out></a></th>
      <th scope="row"><c:out value="${language.creator }"></c:out></th>
      <th scope="row"><c:out value="${language.currentVersion }"></c:out></th>
      <th scope="row" style="width: 50px;outline: black; solid 2px;">
      <form:form action="/delete/${language.id }" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="delete">
      <button type="submit" class="btn btn-link">Delete</button>
      </form:form></th>
 <th scope="row"><a href="/languages/edit/${language.id}">Edit</a></th>
      
      

    </tr>
    </c:forEach>
  </tbody>
</table>
<div style="margin:20px 0px 0px 50px;">
<form:form action="/create" method="post" modelAttribute="lang">
    <p>
        <form:label path="name">Name</form:label>
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
    <button type="submit" class="btn btn-outline-primary">Add</button>
</form:form>  
</div>
</body>
</html>