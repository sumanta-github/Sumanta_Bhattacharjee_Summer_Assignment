package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import beans.*;
import DAO.*;

public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    	String Id = request.getParameter("id");

    	DeleteCommentBean deleteBean=new DeleteCommentBean();
    	deleteBean.setComment(Id);
    	MvcJDBCDAO dao=new MvcJDBCDAO();
    	dao.delete(deleteBean);
    	RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
    	rd.forward(request, response);

  	}



}