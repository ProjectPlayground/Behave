import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

public class Mode implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4435930128354401336L;

	/* Variables */
	protected String modeName;
	
	protected ArrayList<Token> tokens = new ArrayList<Token>();
	protected ArrayList<Reward> rewards = new ArrayList<Reward>();
	
	protected int tokenAccumulator = 0;
	protected int tokenTimer = 1;
	protected int hash = 0;
	transient Timer timer = new Timer();
	
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
			}
		}
		return cost;
	}
	
	/* Setters */
	public void setName(String name)
	{
		modeName = name;
	}
	
	public void setTokenAccu(int amount, int interval)
	{
		this.tokenAccumulator = amount;
		this.tokenTimer = interval;
		timer.cancel();
		this.timer = new Timer();
		
		timer.schedule(
			    new java.util.TimerTask() 
			    {
			        @Override
			        public void run() 
			        {
			        	for(int i = 0; i < amount; i++)
			        	{
			        		addToken("AutoToken " + hash);
			        		hash++;
			        	}
			        }
			    }, 1, tokenTimer*1000);
	}
	
	/* Getters */
	public String getName()
	{
		return modeName;
	}
	
	public int getTimer()
	{
		return tokenTimer;
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
	
	public int getTokensUpToDate(long time)
	{
		int count = 0;
		
		for (Token token : tokens)
		{
			if (token.getTimeStamp() < time)
			{
				count++;
			}
		}
		
		return count;
	}
	
	public long getSmallestDate()
	{
		long number = Long.MAX_VALUE;
		
		for (Token token : tokens)
		{
			if (token.getTimeStamp() < number)
			{
				number = token.getTimeStamp();
			}
		}
		return number;
	}

	public long getLargestDate()
	{
		long number = Long.MIN_VALUE;
		
		for (Token token : tokens)
		{
			if (token.getTimeStamp() > number)
			{
				number = token.getTimeStamp();
			}
		}
		return number;
	}
}
