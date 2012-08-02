package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.net.*;

public class ConnectionFactory {
        static String driverClassName;
        static String connectionUrl;
		static String loginTable;
		static String messageTable;

        private static ConnectionFactory connectionFactory = null;


		static String getLoginTable()
		{
			return loginTable;
		}

		static String getMessageTable()
		{
			return messageTable;
		}

        private ConnectionFactory() {
                try {
						URL url = getClass().getResource("Config.txt");
						URLConnection conn = url.openConnection();
						InputStream istream = conn.getInputStream();
						BufferedReader br=new BufferedReader(new InputStreamReader(istream));
						String entry;
						for(int i=0;i<4;i++)
						{
							if((entry=br.readLine())==null)
								System.out.println("error");
							StringTokenizer st=new StringTokenizer(entry,"#");
							String a=st.nextToken();
							String b=st.nextToken();
							a=a.trim();
							b=b.trim();
							if(a.equalsIgnoreCase("DRIVER"))driverClassName=b;
							else if(a.equalsIgnoreCase("DATABASE"))connectionUrl=b;
							else if(a.equalsIgnoreCase("LOGIN TABLE"))loginTable=b;
							else if(a.equalsIgnoreCase("MESSAGE TABLE"))messageTable=b;
							else System.out.println("error");
						}
						br.close();

                        Class.forName(driverClassName);

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public Connection getConnection() throws SQLException {
                Connection conn = null;
                conn = DriverManager.getConnection(connectionUrl);
                return conn;
        }

        public static ConnectionFactory getInstance() {
                if (connectionFactory == null) {
                        connectionFactory = new ConnectionFactory();
                }
                return connectionFactory;
        }
}