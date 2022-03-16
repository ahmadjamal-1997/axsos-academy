<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/" method="post">
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">select number</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="quantity" name="quantity" min="5" max="25">
    </div>
  </div>
    <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">enter the name of any city</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="city">
    </div>
  </div>
  
  <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">name of real person</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" name="name">
    </div>
  </div>
    <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">enter profetional endavor or hopy</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" name="hope">
    </div>
  </div>
    <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">enter any type of living thing</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" name="type">
    </div>
  </div>
    <div class="row mb-3">
    <label for="inputPassword3" class="col-sm-2 col-form-label">say somthing nice to some one</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" name="message">
    </div>
  </div>
  <button type="submit" class="btn btn-primary">submit</button>
</form>
</body>
</html>