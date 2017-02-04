import java.util.ArrayList;

public class Mode 
{
	/* Variables */
	protected String modeName;
	protected ArrayList<Token> tokens = new ArrayList<Token>();
	protected ArrayList<Reward> rewards = new ArrayList<Reward>();
	
	/* Constructor */
	public Mode(String name)
	{
		this.modeName = name;
	}
	
	/* Setters */
	public void setName(String name)
	{
		modeName = name;
	}
	
	/* Getters */
	public String getName()
	{
		return modeName;
	}
	
	public ArrayList<Token> getTokens()
	{
		return tokens;
	}
	
	public ArrayList<Reward> getRewards()
	{
		return rewards;
	}
}
