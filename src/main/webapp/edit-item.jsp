<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Edit A Car</title>
</head>

<body>
<div class="container">

<h2>Edit This Car </h2>

<small class="text-muted">Make changes to the make, model, year, or horsepower</small>
<br />

<form action = "editItemServlet" method="post">
<div class="form-group">
<label for="make">Make:</label><input type ="text" name = "make" value= "${itemToEdit.make}"><br />
</div>

<div class="form-group">
<label for="item">Model:</label>
<input type = "text" name = "model"  value= "${itemToEdit.model}"><br />
</div>

<div class="form-group">
<label for="make">Year:</label><input type ="text" name = "year" value= "${itemToEdit.year}"><br />
</div>

<div class="form-group">
<label for="make">Horsepower:</label><input type ="text" name = "horsepower" value= "${itemToEdit.horsepower}"><br />
</div>

<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item" class="btn btn-primary">

</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</div>

</body>
</html>