import java.util.ArrayList;
import java.util.Iterator;

public class Mode 
{
	/* Variables */
	protected String modeName;
	protected ArrayList<Token> tokens = new ArrayList<Token>();
	protected ArrayList<Reward> rewards = new ArrayList<Reward>();
	protected int tokenAccumulator = 0;
	
	/* Constructor */
	public Mode(String name)
	{
		this.modeName = name;
	}
	
	/* Methods */
	
	public void addToken(String name)
	{
		tokens.add(new Token(name));
	}
	
	public void editToken(String name, String newName)
	{
		for (Token token : tokens)
		{
			if (token.getName().equals(name))
			{
				token.setName(newName);
				break;
			}
		}
	}
	
	public void deleteToken(String tokenName)
	{
		Iterator<Token> it = tokens.iterator();
		while (it.hasNext())
		{
			Token token = it.next();
			if (token.getName().equals(tokenName))
			{
				it.remove();
			}
		}
	}
	
	public void addReward(String rewardName, int rewardCost) 
	{
		rewards.add(new Reward(rewardName, rewardCost));
	}
	
	public void editReward(String rewardName, String newRewardName, int newRewardCost) 
	{
		for (Reward reward : rewards)
		{
			if (reward.getName().equals(rewardName))
			{
				reward.setName(newRewardName);
				reward.setCost(newRewardCost);
			}
		}
	}	
	
	public void deleteReward(String rewardName) 
	{
		Iterator<Reward> it = rewards.iterator();
		while (it.hasNext())
		{
			Reward reward = it.next();
			if (reward.getName().equals(rewardName))
			{
				it.remove();
			}
		}
	}
	
	public int redeemReward(String rewardName, int amount)
	{
		int cost = 0;
		Iterator<Reward> it = rewards.iterator();
		while (it.hasNext())
		{
			Reward reward = it.next();
			if (reward.getName().equals(rewardName))
			{
				cost = reward.getCost();
				if (amount < cost)
				{
					System.out.println("You dont have enough tokens for this!");
					break;
				}
				it.remove();
			}
		}
		return cost;
	}
	
	/* Setters */
	public void setName(String name)
	{
		modeName = name;
	}
	
	public void setTokenAccu(int amount)
	{
		this.tokenAccumulator = amount;
	}
	
	/* Getters */
	public String getName()
	{
		return modeName;
	}
	
	public int getTokenAccu()
	{
		return tokenAccumulator;
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
