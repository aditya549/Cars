<%@page import="bean.userbean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction" %>
<%@page import="org.hibernate.Criteria" %>
<%@page import="org.hibernate.criterion.Order" %>
<%@page import="org.hibernate.Session"%>
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
<table border="2">
<tr>
<th>Id</th>
<th>name</th>
<th>Email</th>
<th>Age</th>
<th>Gender</th>
<th>Address</th>
<th>contact</th>
<th>To Do's</th>
</tr>
<%
try{
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session2=factory.openSession();
	Transaction t=session2.beginTransaction();
	Criteria c=session2.createCriteria(userbean.class);
    c.addOrder(Order.asc("id"));
	List<userbean> ll=c.list();
	Iterator<userbean> itr=ll.iterator();
	
	while(itr.hasNext()){
		userbean user=(userbean)itr.next();
		%>
		<tr>
		<td><%=user.getId() %></td>
		<td><%=user.getName() %></td>
		<td><%=user.getEmail() %></td>
		<td><%=user.getAge() %></td>
		<td><%=user.getGender() %></td>
		<td><%=user.getAddress() %></td>
		<td><%=user.getContact() %></td>
		<td><a href="edit.jsp?name=<%=user.getName()%>">EDIT</a>  <a href="delete.jsp?name=<%=user.getName()%>">DELETE</a></td>
		</tr>
		<% 
		
	}
	t.commit();
	System.out.println("success");
	session2.close();
	factory.close();

}catch(Exception e){
	System.out.println(e);
}

%>
</table>
<a href="index.html">HOME</a>
</body>
</html>