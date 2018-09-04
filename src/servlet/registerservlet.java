package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.userbean;
import dao.registerdao;

/**
 * Servlet implementation class registerservlet
 */
@WebServlet("/registerservlet")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		userbean user=new userbean();
  		user.setName(request.getParameter("name"));
  		user.setEmail(request.getParameter("email"));
  		user.setPassword(request.getParameter("password"));
  		user.setAge(Integer.parseInt(request.getParameter("age")));
  		user.setGender(request.getParameter("gender"));
  		user.setAddress(request.getParameter("address"));
  		user.setContact(request.getParameter("contact"));
  		
  		registerdao.register(user);
  		boolean stat=user.isValid();
  		if(stat) {
  			response.sendRedirect("index.html");	
  		}
  		
  		
  		
  		}

}
