import java.io.Serializable;

public class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5166531754963482012L;
	/**
	 * 
	 */
	/* Variables */
	protected String name;
	
	/* Constructors */
	
	public Person(String name)
	{
		this.name = name;
	}
	
	/* Getters */
	public String getName()
	{
		return name;
	}
	
	/* Setters */
	public void setName(String name)
	{
		this.name = name;
	}
}
