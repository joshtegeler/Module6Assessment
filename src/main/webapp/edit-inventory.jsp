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
<title>Edit An Existing Inventory</title>
</head>
<body>
<h1>View/Edit Inventory</h1>
<form action = "editInventoryDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${inventoryToEdit.id}">
Inventory Name: <input type ="text" name = "inventoryName" value= "${inventoryToEdit.inventoryName}"><br />
Hire date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
Salesman Name: <input type = "text" name = "salesmanName" value= "${inventoryToEdit.salesman.salesmanName}"><br />

Available Cars:<br />

<select name="allInventoriesToAdd" multiple size="6">
<c:forEach items="${requestScope.allInventories}" var="currentcar">
   <option value = "${currentcar.id}">${currentcar.make} | ${currentcar.model}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit Inventory and Add Cars">
</form>
<a href = "index.html">Go add new cars instead.</a>
</body>
</html>