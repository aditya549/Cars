<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registerservlet" method="post">
name:<input type="text" name="name"  placeholder="enter your name"><br>
Email:<input type="text" name="email" placeholder="enter your email"><br>
password:<input type="password" name="password" placeholder="enter your password"><br>
age:<input type="text" name="age" placeholder="enter your age"><br>
address:<input type="text" name="address" placeholder="enter your address"><br>
gender:<input type="radio" name="gender" value="male">male<br>
<input type="radio" name="gender" value="female">female<br>
contact:<input type="text" name="contact" placeholder="enter your no"><br>
<input type="submit" value="submit">



</form>
</body>
</html>