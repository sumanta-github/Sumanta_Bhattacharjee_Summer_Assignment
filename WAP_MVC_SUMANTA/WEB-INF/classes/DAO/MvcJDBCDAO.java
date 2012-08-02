package DAO;
import beans.*;

import java.text.*;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MvcJDBCDAO {
        Connection connection = null;
        PreparedStatement ptmt = null;
        ResultSet result = null;
		private HashMap<String,String> comments;

        public MvcJDBCDAO() {

        }

        private Connection getConnection() throws SQLException {
                Connection conn;
                conn = ConnectionFactory.getInstance().getConnection();
                return conn;
        }

		public boolean login(String userName, String password) {
    	try {
            	connection = getConnection();

				String tablename=ConnectionFactory.getInstance().getLoginTable();
      			Statement s = connection.createStatement();
      			String sql = "SELECT UserName FROM "+tablename+"  WHERE UserName='" + userName + "'"
      											+ " AND Password='" + password + "'";
      			result = s.executeQuery(sql);
      			if (result.next())
        			return true;
      			else
      				return false;

        	} catch (SQLException e) {
				e.printStackTrace();
            } finally {
				try {
		             if (ptmt != null)
                            ptmt.close();
			         if (connection != null)
			         		connection.close();
			    } catch (SQLException e) {
			                    e.printStackTrace();
			    } catch (Exception e) {
			             e.printStackTrace();
			    }

                }
    	return false;
  	}




        public void add(InsertCommentBean insertBean) {
                try {

						DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						java.util.Date date=new java.util.Date();
						String date_time=dateFormat.format(date);
						String id=insertBean.getUserName()+"#"+date;


						String tablename=ConnectionFactory.getInstance().getMessageTable();
                        String queryString = "INSERT INTO "+tablename+"(ID, comment,DATE) VALUES(?,?,?)";
                        connection = getConnection();
                        ptmt = connection.prepareStatement(queryString);
                        ptmt.setString(1, id);
                        ptmt.setString(2, insertBean.getComment());
                        ptmt.setString(3, ""+date);
                        ptmt.executeUpdate();

                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (ptmt != null)
                                        ptmt.close();
                                if (connection != null)
                                        connection.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                }

        }


        public void delete(DeleteCommentBean deleteBean) {

                try {

						String tablename=ConnectionFactory.getInstance().getMessageTable();
                        String queryString = "DELETE FROM "+tablename+" WHERE ID=?";
                        connection = getConnection();
                        ptmt = connection.prepareStatement(queryString);
                        ptmt.setString(1, deleteBean.getId());
                        ptmt.executeUpdate();

                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (ptmt != null)
                                        ptmt.close();
                                if (connection != null)
                                        connection.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                }

        }

        public HashMap<String,String> findAll() {
                try {
						String tablename=ConnectionFactory.getInstance().getMessageTable();
                        String queryString = "SELECT * FROM "+tablename;
                        connection = getConnection();
                        ptmt = connection.prepareStatement(queryString);
                        result = ptmt.executeQuery();

                        comments=new HashMap<String,String>();
                        while (result.next())
                        {
                                String id = result.getString(1);
				                String comment = result.getString(2);
                				comments.put(id,comment);
                        }

                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (result != null)
                                        result.close();
                                if (ptmt != null)
                                        ptmt.close();
                                if (connection != null)
                                        connection.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                }
        		return comments;
        }

}