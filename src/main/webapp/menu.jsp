<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function editItem(id){
	alert('edit triggered!! for '+ id);
	document.forms[0].action="editItemView?itemId="+id; //itemId is a RequestParam, we access id by using this name.
	document.forms[0].method="post";
	document.forms[0].submit();
}

function deleteItem(id){
	alert('delete triggered!! for ' + id);
	document.forms[0].action="deleteItem?itId="+id; //itId is a RequestParam, we access id by using this name.
	document.forms[0].method="post";
	document.forms[0].submit();
}
</script>
</head>
<body>
<font color="red">${msg}</font>
<a href="<core:url value="/j_spring_security_logout" />" >Logout</a></br>
<form action="deleteMultiple">
<table border="1">
<tr>
<th>ItemId</th>
<th>Item</th>
<th>Price</th>
<th>Veg/NonVeg</th>
<th>Qty</th>
</tr>
<core:forEach var="item" items="${menuData}">
 <tr>
 	<td>${item.itemId}</td>
 	<td>${item.item}</td>
 	<td>${item.price}</td>
 	<td>${item.typeOfItem}</td>
 	<td>${item.qty}</td>
 	<td><input type="button" onclick="editItem('${item.itemId}')" value="Edit"/></td> <!-- added an event onclick. onclick calling a java script function editItem which is thre in scprit tag of this file -->
 	<td><input type="button" onclick="deleteItem('${item.itemId}')" value="Delete"/></td> <!-- added an event onclick. onclick calling a java script function deleteItem which is thre in scprit tag of this file -->
 	<td><input type="checkbox" name="itemCheckBox" value="${item.itemId}"></td>
 </tr>
</core:forEach>
</table>
<input type="submit" value="Delete Multiple"/>
</form>
<a href="goToHomePage">Click Here</a> for Home page
</body>
</html>