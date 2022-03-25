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
<title>Book Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body style="margin: 50px 0px 0px 30px">
	<h1>${book.title }</h1>
	<a href="/home">Back to the shelves</a>
	<p>${book.user.userName } read ${book.title } by ${book.author } </p>
	<p>Here are ${book.user.userName } 's thoughts</p>
	<hr>
	<p> ${book.thoughts } </p>
	<hr>
	<form:form action="/books/${book.id }/edit" method="post"  modelAttribute="book">
	  <button type="submit" class="btn btn-primary mt-3">Edit</button>
  </form:form>
</body>
</html>