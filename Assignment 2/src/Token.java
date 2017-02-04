import java.util.Date;

public class Token 
{
	/* Variables */
	protected String name;
	protected Date timeStamp;
	
	/* Constructor */
	
	public Token(String name)
	{
		this.name = name;
		this.timeStamp = new java.util.Date();
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
	
	public Date getTimeStamp()
	{
		return timeStamp;
	}
}
