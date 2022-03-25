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
<h1>Edit Project</h1>

<div class="row">
    <div class="col">
        <form:form action="/edit/${thisProject.id}" method="post"  modelAttribute="edited">
        <input type="hidden" name="_method" value="put">
    <div class="row">
    <div class="col-auto">
  <div class="row">
    <form:label path="title"  class="col-form-label">Project Title </form:label>
  </div>
  <form:errors path="title"/>
  <div class="row">
    <form:input path="title"  class="form-control" aria-describedby="nameHelpInline"/>
  </div>
  <div class="row">
    <form:label path="description"  class="col-form-label">description </form:label>
  </div>
  <form:errors path="description"/>
  <div class="row">
    <form:input path="description"  class="form-control" aria-describedby="emailHelpInline"/>
  </div>
  <div class="row">
    <form:label  path="dueDate"  class="col-form-label">Due Date </form:label>
  </div>
  <form:errors path="dueDate"/>
  <div class="row">
    <form:input path="dueDate" type="date" class="form-control" aria-describedby="passwordHelpInline"/>
  </div>
  <div>
  <button type="submit" class="btn btn-primary mt-3">Submit</button>
  </div>
  </form:form>
   <a href="/home"><button class="btn btn-primary mt-3">Cancel</button></a>
  
    </div>
    </div>

</body>
</html>