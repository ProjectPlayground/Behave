import java.io.Serializable;

public class Reward implements Serializable
{
	private static final long serialVersionUID = 107920696175806625L;
	/* Variables */
	protected String name;
	protected int tokenCost = 1;
	
	/* Constructor */
	
	public Reward(String name, int tokenCost)
	{
		this.name = name;
		this.tokenCost = tokenCost;
	}
	
	public Reward(String name)
	{
		this.name = name;
	}
	
	/* Setters */
	
	public void setName(String newName)
	{
		name = newName;
	}
	public void setCost(int newCost)
	{
		tokenCost = newCost;
	}
	
	/* Getters */
	
	public String getName()
	{
		return name;
	}
	
	public int getCost()
	{
		return tokenCost;
	}
}
