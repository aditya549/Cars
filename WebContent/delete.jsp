<%@page import="bean.userbean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction" %>
<%@page import="org.hibernate.Criteria" %>
<%@page import="org.hibernate.criterion.Order" %>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>

<%@page import="org.hibernate.query.Query"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	Transaction t=session2.beginTransaction();
	Query q=session2.createQuery("from userbean where name=:name");
	q.setString("name", name1);

	userbean user=(userbean)q.uniqueResult();
	session2.delete(user);
	t.commit();
	System.out.println("success");
	response.sendRedirect("fetch.jsp");
	session2.close();
	factory.close();

}catch(Exception e){
	System.out.println(e);
}

%>

</body>
</html>