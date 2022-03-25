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
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h3>Hello <c:out value="${thisUser.userName}"></c:out>.Welcome to</h3>
<a href="/logout">Logout</a>
<h1>The Book Broker!</h1>
<p>available books to borrow</p>
<table class="table" style="width : 500px;">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
    
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${notBorrowed}">
    <tr>
 		<td><c:out value="${book.id}"></c:out></td>
      <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
      <td><c:out value="${book.author}"></c:out></td>
      <td><c:out value="${book.user.userName}"></c:out></td>
      <c:choose>
      <c:when test="${thisUser.id == book.user.id}">
      <td><a href="/books/${book.id}/edit"><button class="btn btn-primary ">Edit</button></a> | <form:form action="/delete/${book.id }" method="post"  modelAttribute="book">
          <input type="hidden" name="_method" value="delete">
      <th scope="row"><button type="submit" class="btn btn-danger">Delete</button></th>
       </form:form> </td></c:when>
      <c:otherwise><td><a href="/borrow/${book.id}">Borrow</a></td></c:otherwise>
      </c:choose>
      
    </tr>
    </c:forEach>
  </tbody>
</table>
<p>Books i'm Borrowing</p>
<table class="table" style="width : 500px;">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
    
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${thisUser.manybooks}">
    <tr>
 		<td><c:out value="${book.id}"></c:out></td>
      <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
      <td><c:out value="${book.author}"></c:out></td>
      <td><c:out value="${book.user.userName}"></c:out></td>
      <td><a href="return/${book.id}">return</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>