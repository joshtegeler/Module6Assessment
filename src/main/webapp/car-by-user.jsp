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
<title>Inventory</title>
</head>
<body>

<h1>View Inventories</h1>
<form method="post" action="inventorynavigationServlet">
<table>
<c:forEach items="${requestScope.allInventories}" var="currentinventory">
<tr>
	<td><input type="radio" name="id" value="${currentinventory.id}"></td>
	<td><h2> Inventory Name: ${currentinventory.inventoryName}</h2></td>
</tr>
	
<tr>
	<td colspan="3">Hire Date: ${currentinventory.startDate}</td>
</tr>

<tr>
	<td colspan="3">Salesman: ${currentinventory.salesman.salesmanName}</td>
</tr>
<c:forEach var="inventoryVal" items="${currentinventory.listOfItems}">
<tr><td></td>
<td colspan="3">
${inventoryVal.make}, ${inventoryVal.model}, ${inventoryVal.year}, ${inventoryVal.horsepower}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToInventory">
<input type="submit" value="delete" name="doThisToInventory">
<input type="submit" value="add" name="doThisToInventory">

</form>
<a href="addItemsForInventoryServlet">Create a new inventory</a><br />
<a href="index.html">Insert a new car</a>
</body>
</html>