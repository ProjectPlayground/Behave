import java.util.ArrayList;

public abstract class TokenManager extends Person 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 24086341589368821L;
	/* Variables */
	protected ArrayList<Child> children = new ArrayList<Child>();
	
	/*Constructors */
	public TokenManager(String name) 
	{
		super(name);
	}
	
	/* Methods */
	abstract void addChild(String childName);
	
	abstract void editChild(String childName, String newName);
	
	abstract void deleteChild(String childName);
	
	abstract void addToken(String childName, String tokenName);
	
	abstract void editToken(String childName, String tokenName, String newTokenName);
	
	abstract void deleteToken(String childName, String tokenName);
	
	abstract void addTokenAccu(String childName, int amount, int interval);
	
	abstract void addReward(String childName, String rewardName, int rewardCost);
	
	abstract void editReward(String childName, String rewardName, String newName, int newRewardCost);
	
	abstract void deleteReward(String childName, String rewardName);
	
	public void childrenStatus()
	{
		for (Child child : children)
		{
			System.out.println("\nCurrent Child: " + child.getName());
			for (Mode mode : child.getModeList())
			{
				System.out.println(mode.getName());
				System.out.println("____________________");
				System.out.println("	Tokens  | " + mode.getTokens().size());
				System.out.println("	Rewards | " + mode.getRewards().size()+ "\n");
			}
		}
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
