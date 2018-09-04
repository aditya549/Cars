package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import bean.userbean;

public class updatedao {

	public static void update(userbean user) {
		// TODO Auto-generated method stub
		try {
			Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
			SessionFactory f=cfg.buildSessionFactory();
			Session s=f.openSession();
			Transaction t=s.beginTransaction();
			
			s.update(user);
			t.commit();
			user.setValid
			(true);
			System.out.println("success fully registered");
			s.close();
			f.close();
		}catch (Exception e) {

		System.out.println(e);
		}
		

	}

}
