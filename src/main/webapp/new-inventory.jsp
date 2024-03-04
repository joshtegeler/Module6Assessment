<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Create a new inventory</title>
</head>
<body>
<h1> Create New Inventory</h1>
<form action = "createNewInventoryServlet" method="post">
Inventory Name: <input type="text" name = "inventoryName"><br />
Trip Date: <input type="text" name = "month" placeholder="mm" size="4">
<input type="text" name = "day" placeholder="dd" size="4">
<input type="text" name = "year" placeholder="yyyy" size="4">
Salesman Name: <input type="text" name = "salesmanName"><br />

Available Cars:<br />
<select name = "allCarsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allCars}" var="currentcar">
<option value = "${currentcar.id}"> ${currentcar.year} ${currentcar.make} ${currentcar.model} , ${currentcar.horsepower} Horsepower</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create Inventory and Add Cars">

</form>
<a href="index.html">Go add new cars instead</a>
</body>
</html>