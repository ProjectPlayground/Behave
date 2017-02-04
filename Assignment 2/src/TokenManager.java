import java.util.ArrayList;

public class TokenManager extends Person 
{
	/* Variables */
	protected ArrayList<Child> children = new ArrayList<Child>();
	protected ArrayList<Mode> modes = new ArrayList<Mode>();
	
	/*Constructors */
	public TokenManager(String name) 
	{
		super(name);
	}
	
	/* Methods */
	public void addChild(String childName)
	{
		children.add(new Child(childName, this));
	}
	
	public void editChild(String childName, String newName)
	{
		for (Child child : children)
		{
			if (child.getName().equals(childName))
			{
				child.setName(newName);
				break;
			}
		}
	}
	
	public void deleteChild(String childName)
	{
		for (Child child : children)
		{
			if (child.getName().equals(childName))
			{
				children.remove(child);
				break;
			}
		}
	}
	
	public void addToken(String childName, String tokenName)
	{
		
	}
	
	public void editToken(String childName, String tokenName, String newTokenName)
	{
		
	}
	
	public void deleteToken(String childName, String tokenName)
	{
		
	}
	
	public void addReward(String childName, String rewardName, int rewardCost)
	{
		
	}
	
	public void
	
	
	
	/* Setters */
	
	/* Getters */
	public ArrayList<Child> getchildren()
	{
		return children;
	}
	
	public int getChildrenCount()
	{
		return children.size();
	}
}
