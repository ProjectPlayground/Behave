import java.util.ArrayList;
import java.util.Iterator;

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
		Iterator<Child> it = children.iterator();
		while (it.hasNext())
		{
			Child child = it.next();
			if (child.getName().equals(childName))
			{
				it.remove();
			}
		}
	}
	
	public void addToken(String childName, String tokenName)
	{
		if (getChild(childName) == null)
		{
			return;
		}
		getChild(childName).getCurrentMode().addToken(tokenName);
	}
	
	public void editToken(String childName, String tokenName, String newTokenName)
	{
		if (getChild(childName) == null)
		{
			return;
		}
		getChild(childName).getCurrentMode().editToken(tokenName, newTokenName);
	}
	
	public void deleteToken(String childName, String tokenName)
	{
		if (getChild(childName) == null)
		{
			return;
		}
		getChild(childName).getCurrentMode().deleteToken(tokenName);
	}
	
	public void addTokenAccu(String childName, int amount)
	{
		if (getChild(childName) == null)
		{
			return;
		}
		getChild(childName).getCurrentMode().setTokenAccu(amount);
	}
	
	public void addReward(String childName, String rewardName, int rewardCost)
	{
		if (getChild(childName) == null)
		{
			return;
		}
		getChild(childName).getCurrentMode().addReward(rewardName, rewardCost);
	}
	
	public void editReward(String childName, String rewardName, String newName, int newRewardCost)
	{
		if (getChild(childName) == null)
		{
			return;
		}
		getChild(childName).getCurrentMode().editReward(rewardName, newName, newRewardCost);
	}
	
	public void deleteReward(String childName, String rewardName)
	{
		if (getChild(childName) == null)
		{
			return;
		}
		getChild(childName).getCurrentMode().deleteReward(rewardName);
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
