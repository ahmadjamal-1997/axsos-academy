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
<h1 style="margin-left: 20px;margin-bottom: 40px;"><c:out value="${product.name}"></c:out></h1>
<form action="/addcategories/${product.id}" method="post"  style="width:400px;">
<div style="display: flex;width: 600px;justify-content: space-around;">
  <div style="margin-left: 20px;">
    <h3>Categories</h3>
        <c:forEach var="category" items="${product.categories}" >
        <p><c:out   value="${category.name}"></c:out></p>
        </c:forEach>
        </div>
        <div>
		<select class="form-select" name="categoryid">
			<c:forEach var="category" items="${categories}" >
				<option value="${category.id}" >
					<c:out   value="${category.name}"></c:out>
				</option>
			</c:forEach>
		</select>

    <button type="submit" style="margin-top: 20px">Add</button>
    </div>
    </div>
	</form> 
	
</body>
</html>