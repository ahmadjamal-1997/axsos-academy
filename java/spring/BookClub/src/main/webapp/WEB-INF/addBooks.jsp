<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>Add a Book to your Shelf!</h1>
<a href="/home">Back to the shelves</a>
<div class="row">
	<div class="col">
		<form:form action="/createBook" method="post"  modelAttribute="book">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="title"  class="col-form-label">Title </form:label>
  </div>
  <form:errors path="title"/>
  <div class="row">
    <form:input path="title"  class="form-control" aria-describedby="nameHelpInline"/>
  </div>
  <div class="row">
    <form:label path="author"  class="col-form-label">Author </form:label>
  </div>
  <form:errors path="author"/>
  <div class="row">
    <form:input path="author"  class="form-control" aria-describedby="emailHelpInline"/>
  </div>
  <div class="row">
    <form:label  path="thoughts"  class="col-form-label">thoughts </form:label>
  </div>
  <form:errors path="thoughts"/>
  <div class="row">
    <form:input path="thoughts"  class="form-control" aria-describedby="passwordHelpInline"/>
  </div>
  <button type="submit" class="btn btn-primary mt-3">Submit</button>
  </form:form>
	</div>
	</div>

</body>
</html>