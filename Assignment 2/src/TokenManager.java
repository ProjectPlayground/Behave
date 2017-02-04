import java.util.ArrayList;

public class TokenManager extends Person 
{
	/* Variables */
	protected ArrayList<Child> children = new ArrayList<Child>();
	
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
	
	public void addToken(String childName, String modeName, String tokenName)
	{
		
	}
	
	public void editToken(String childName, String modeName, String tokenName, String newTokenName)
	{
		
	}
	
	public void deleteToken(String childName, String modeName, String tokenName)
	{
		
	}
	
	public void addReward(String childName, String modeName, String rewardName, int rewardCost)
	{
		
	}
	
	public void editReward(String childName, String modeName, String rewardName, String newName, int newRewardCost)
	{
		
	}
	
	public void deleteReward(String childName, String modeName, String rewardName)
	{
		
	}
	
	/* Getters */
	public Child getChild(String childName)
	{
		for (Child child : children)
		{
			if(child.getName().equals(childName))
			{
				return child;
			}
		}
		return null;
	}
	
	public ArrayList<Child> getchildren()
	{
		return children;
	}
	
	public int getChildrenCount()
	{
		return children.size();
	}
}
