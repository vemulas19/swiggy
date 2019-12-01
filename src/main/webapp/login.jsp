<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<font color="red">
${message} </br></br>
${message2}
</font>
<form action="<c:url value='j_spring_security_check'/>" method="post">
UserName : <input type="text" name="userName"/> </br>
Password : <input type="password" name="pwd"/> </br>
<input type="submit" value="Login"/>
</form>


<a href="goToHomePage">Click Here</a> for Home page
</body>
</html>