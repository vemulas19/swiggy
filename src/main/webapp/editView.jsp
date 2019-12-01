<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="<core:url value="/j_spring_security_logout" />" >Logout</a></br>
<form action="updateItem" method="post">
Item Id : <input type="text" name="itemId" readonly="readonly" value="${itInfo.itemId}"/></br>
Item : <input type="text" name="item" value="${itInfo.item}" /> </br>
Price : <input type="text" name="price" value="${itInfo.price}" /></br>
Quantity : <input type="text" name="qty" value="${itInfo.qty}"/> </br>
Veg: <input type="radio" name="typeOfItem" ${veg} value="Veg"/></br>
Non Veg: <input type="radio" name="typeOfItem" ${nonVeg} value="NonVeg"/></br>
<input type="submit" value="Update"/>
</form>
</body>
</html>