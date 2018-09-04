<%@page import="bean.userbean"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction" %>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
	String name1=request.getParameter("name");
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session2=factory.openSession();
	Transaction t =session2.beginTransaction();
	Query query=session2.createQuery("from userbean where name=:name");
	query.setString("name", name1);
	userbean user=(userbean)query.uniqueResult();
	
	%>
<h1>User Details</h1>
<form action="updateservlet" method="post">
name:<input type="text" name="name"  placeholder="enter your name" value=<%= user.getName() %>><br>
Email:<input type="text" name="email" placeholder="enter your email" value=<%= user.getEmail() %> ><br>
password:<input type="text" name="password" placeholder="enter your password" value=<%= user.getPassword() %>><br>
age:<input type="text" name="age" placeholder="enter your age" value=<%= user.getAge() %>><br>
address:<input type="text" name="address" placeholder="enter your address" value=<%= user.getAddress() %>><br>
gender:
<% if(user.getGender().equals("male")){%>

<input type="radio" name="gender" value="male" checked="checked">male<br>
<input type="radio" name="gender" value="female">female<br>
<%
					}else{
						%>
			<input type="radio" id="gender" name="gender" value="male" />Male  
              <input type="radio" id="gender" name="gender" value="female" checked="checked"/>Female <br/> 
						
						<%
					
					
					}
						%>
				
contact:<input type="text" name="contact" placeholder="enter your no" value=<%= user.getContact() %>><br>
<input type="submit" value="Update">
</form>
	<% 
	t.commit();
	session2.close();
	factory.close();
}catch(Exception e){
	System.out.println(e);
}



%>
</body>
</html>