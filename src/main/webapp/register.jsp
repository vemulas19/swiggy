<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${message}</font>
<form action="registerUser" method="post">
	Name : <input type="text" name="name"/></br>
	Mobile Number : <input type="text" name="mobile"/></br>
	MailId : <input type="text" name="mailId"></br>
	Password : <input type="password" name="password"/></br>
	City : <input type="text" name="city"/> </br>
	<input type="submit" value="Register"/></br>
	<a href="login.jsp">Click Here</a> for login page
</form>
<a href="goToHomePage">Click Here</a> for Home page
<br><br><br>

<form action="testIoc">
<input type="submit" value="TestIoc"/>
</form>
</body>
</html>