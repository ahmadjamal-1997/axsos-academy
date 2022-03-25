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
<h3>Weelcome <c:out value="${thisUser.userName}"></c:out></h3>
<a href="/logout">Logout</a>
<p>All projects</p>
<a href="/project/new"><button type="submit">+ new project</button></a>
<table class="table" style="width : 500px;">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${projects}">
    <tr>
 		
      <td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
      <td><c:out value="${project.user.userName}"></c:out></td>
      <td><c:out value="${project.dueDate}"></c:out></td>
      <td><a href="/jointeam/${project.id}">Join team</a> </td>
    
      
    </tr>
    </c:forEach>
  </tbody>
</table>
<p>Your Projects</p>

<table class="table" style="width : 500px;">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    
    </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${userProjects}">
    <tr>
 		
      <td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
      <td><c:out value="${project.user.userName}"></c:out></td>
      <td><c:out value="${project.dueDate}"></c:out></td>
      <c:choose>
      <c:when test="${thisUser.id == project.user.id}">
      <td><a href="/projects/${project.id}/edit">Edit</a> 
     </c:when>
      <c:otherwise><td><a href="/leaveteam/${project.id}">Leave Team</a></td></c:otherwise>
      </c:choose>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
