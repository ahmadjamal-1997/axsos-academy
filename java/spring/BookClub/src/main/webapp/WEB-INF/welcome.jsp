<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<style>
h1 {
	color: #9900ff;
	margin: 30px 0px 0px 30px;
}
p {
	margin: 30px 0px 0px 30px;
}
a {
	margin: 0px 0px 0px 30px;
}
</style>
</head>
<body>
	<h1>Welcome  , ${thisUser.userName } !</h1>
	<p>Books from everyone's shelves</p>
	<a href="/logout">Log out</a>
	<a href="/books/new">+ add to my shelf </a>
	<table class="table table-striped mx-5" style="width: 900px">
  <thead>
  
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Posted By</th>
      <th scope="col">Delete a book</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var = "books" items = "${books }">
    <tr>
      <th scope="row">${books.id }</th>
      <th scope="row"><a href="/books/${books.id }">${books.title }</a></th>
      <th scope="row">${books.author }</th>
      <th scope="row">${books.user.userName }</th>
      	<form:form action="/delete/${books.id }" method="post"  modelAttribute="book">
      	<input type="hidden" name="_method" value="delete">
      <th scope="row"><button type="submit" class="btn btn-primary mt-3">Delete</button></th>
       </form:form>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>