package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import bean.userbean;
import servlet.loginservlet;


public class logindao {

	public static void login(userbean user) {
		// TODO Auto-generated method stub
		try {
			Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
			SessionFactory s=cfg.buildSessionFactory();
			Session session=s.openSession();
			Transaction t=session.beginTransaction();
          String email=user.getEmail();
          String password=user.getPassword();
         
		  Query q =session.createQuery("  from userbean where email=:email and  password=:password");
	            q.setString("email",user.getEmail());
	            q.setString("password", user.getPassword());
	            List<userbean> ll=q.list();
	            if(q.list().isEmpty()) {
	            	System.out.println("login failed");
	            }else {
	            	Iterator<userbean> itr=ll.iterator();
	 	           boolean stat=itr.hasNext();
	 	          if(stat) {
	 	        	  user.setValid(true);
	 	        	   userbean s1=(userbean)itr.next();
	 	        	 
	 			       System.out.println(s1.getEmail());
	 	        	   System.out.println(s1.getPassword());
	 	          }
	 	        
	            }
	            
			
			t.commit();
			System.out.println("sucess");
			s.close();
			session.close();
		}catch (Exception e) {

		System.out.println(e);
		}
	}

}
