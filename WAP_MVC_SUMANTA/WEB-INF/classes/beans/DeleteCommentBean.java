package beans;

public class DeleteCommentBean implements java.io.Serializable {
	/* Properties */
	private String id = null;

	/* Empty Constructor */
	public DeleteCommentBean() {}

	/* Getter and Setter Methods */

	public String getId()
	{
		return id;
	}
	public void setComment(String Id)
	{
		id=Id;
	}

}