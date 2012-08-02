package beans;

public class InsertCommentBean implements java.io.Serializable {
	/* Properties */
	private String comment = null;
	private String username=null;
	/* Empty Constructor */
	public InsertCommentBean() {}

	/* Getter and Setter Methods */

	public String getComment()
	{
		return comment;
	}
	public String getUserName()
	{
		return username;
	}



	public void setComment(String s)
	{
		comment = s;
	}
	public void setUserName(String userName)
	{
		username=userName;
	}
}