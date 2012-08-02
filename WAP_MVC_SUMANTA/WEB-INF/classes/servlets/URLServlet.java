package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import beans.*;
import DAO.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="servlets.URLServlet",urlPatterns={"/US"})

public class URLServlet extends HttpServlet {

	static HashMap<String,HttpServlet> URLMap=new HashMap<String,HttpServlet>();
	public void init()
	{
		try{
			URLMap.put("Login",new LoginServlet());
			URLMap.put("Post",new InsertServlet());
			URLMap.put("Delete",new DeleteServlet());
		}catch(Exception e){}
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		URLMap.get(request.getParameter("cmdSubmit")).service(request,response);
  	}


}