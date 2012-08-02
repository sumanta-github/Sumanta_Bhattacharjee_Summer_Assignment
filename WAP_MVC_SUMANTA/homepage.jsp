<%@ page import= "java.util.*"%>

  		<HTML><HEAD><TITLE>Login</TITLE></HEAD><BODY>
  		
  		<h1>Welcome 
  		<%
  		      		String user = (String) session.getAttribute("User");
  				out.println(user);
  		%>
  		</h1>
		<a href="login.html">Log Out</a>
		<%
		
			HashMap<String,String> comments=new DAO.MvcJDBCDAO().findAll();
			Iterator i=comments.keySet().iterator();
			while(i.hasNext())
			{
				Object key=i.next();
				
				String keyStr=key.toString();
				String name=keyStr.substring(0,keyStr.indexOf("#"));
				String date=keyStr.substring(keyStr.indexOf("#")+1,keyStr.length());
				String message=comments.get(key);			
		%>
				<form style="border:solid 2px blue; width:800px" METHOD=POST action="/WAP_MVC_SUMANTA/US">
		
				<font color=GREY><%out.println(name);%>
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<%out.println(date);%>
				</font>
				</br>
				<%out.println(message);%>
				<INPUT TYPE=HIDDEN NAME=id VALUE="<%out.print(keyStr);%>">
				<INPUT TYPE=SUBMIT NAME=cmdSubmit VALUE=Delete>
				</form>
				</br>

		<%
			}		
		%>
  		

  		
  		<BR><BR><FORM style="border:solid 2px green; width:800px" METHOD=POST action="/WAP_MVC_SUMANTA/US">
  		
  		<B>what's in your mind:</B>
  		<BR>
  		<INPUT TYPE=TEXT NAME=comment>
  		<INPUT TYPE=SUBMIT NAME=cmdSubmit VALUE=Post></TD>
  		
  		</FORM>

  		</BODY>
  		</HTML>
