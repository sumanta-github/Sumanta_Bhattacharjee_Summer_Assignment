package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import beans.*;
import DAO.*;



public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String userName = request.getParameter("userName"),
    	 		  password = request.getParameter("password");
    	if (new MvcJDBCDAO().login(userName, password)) {


			HttpSession session = request.getSession(true);
      		session.setAttribute("User", userName);

      		RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
      		rd.forward(request, response);
    	}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
    	}
  	}



}