package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.userbean;
import dao.logindao;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  	userbean user=new userbean();
  	user.setEmail(request.getParameter("email"));
  	user.setPassword(request.getParameter("password"));
  	
  	
  	 	logindao.login(user);
  	 	boolean status=user.isValid();
  	 	if(status){
  	 		response.sendRedirect("fetch.jsp");
  	 	}else {
  	 		response.sendRedirect("index.html");
  	 	}
  	
  	}

}
