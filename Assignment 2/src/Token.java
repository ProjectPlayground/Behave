import java.io.Serializable;

public class Token implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7476187154339979035L;
	/* Variables */
	protected String name;
	protected long timeStamp;
	
	/* Constructor */
	
	public Token(String name)
	{
		this.name = name;
		this.timeStamp = new java.util.Date().getTime();
	}
	
	/* Setters */
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	/* Getters */
	
	public String getName()
	{
		return name;
	}
	
	public long getTimeStamp()
	{
		return timeStamp;
	}
}
