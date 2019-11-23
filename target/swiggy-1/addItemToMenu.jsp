<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="green"> ${message}</font>
<form action="addItemToMenu" method="post">
Item : <input type="text" name="item"/> </br>
Price : <input type="text" name="price"/></br>
Quantity : <input type="text" name="qty"/> </br>
Veg: <input type="radio" name="typeOfItem" value="Veg"/></br>
Non Veg: <input type="radio" name="typeOfItem" value="NonVeg"/></br>
<input type="submit" value="Add"/>
</form>
<a href="goToHomePage">Click Here</a> for Home page
</body>
</html>