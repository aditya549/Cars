package servlet;

import java.io.IOException;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.updatedao;
import bean.userbean;

@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bean.userbean user=new bean.userbean();
		try {
			System.out.println("hello");
			String name=request.getParameter("name");
			System.out.println(name);
			Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
			SessionFactory f=cfg.buildSessionFactory();
			Session s=f.openSession();
			Transaction t=s.beginTransaction();
			org.hibernate.query.Query<userbean> q=s.createQuery("from userbean where name=:name");
			q.setString("name", name);
			userbean ub=(userbean)q.uniqueResult();
			ub.setName(request.getParameter("name"));
			ub.setEmail(request.getParameter("email"));
			ub.setPassword(request.getParameter("password"));
			ub.setAge(Integer.parseInt(request.getParameter("age")));
			ub.setAddress(request.getParameter("address"));
			ub.setGender(request.getParameter("gender"));
			ub.setContact(request.getParameter("contact"));
			
			s.update(ub);
			t.commit();
			//boolean status=user.setValid(true);
			System.out.println("success fully registered");
			s.close();
			f.close();
		}catch (Exception e) {

		System.out.println(e);
		}

		
	}

}
