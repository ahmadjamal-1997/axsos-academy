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
<p><c:out value="${dojo.getName()}"></c:out> Ninjas</p>
<table class="table" style="width : 500px;">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    
    </tr>
  </thead>
  <tbody>
  <c:forEach var="ninja" items="${dojo.ninjas}">
    <tr>
 
      <td><c:out value="${ninja.getFirstName()}"></c:out></td>
      <td><c:out value="${ninja.getLastName()}"></c:out></td>
      <td><c:out value="${ninja.getAge()}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>