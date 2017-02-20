import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI 
{
	ArrayList<Person> users;
	Person currentUser;
	Scanner scan;
	FileHandler fh;
	ChartMaker ch;
	int CHARTINTERVAL = 5;
	
	public ConsoleUI() 
	{
		users = new ArrayList<Person>();
		currentUser = null;
		scan = new Scanner(System.in);
		fh = new FileHandler();
		ch = new ChartMaker(CHARTINTERVAL);
	}
	
	public void run()
	{		
		while(true)
		{
			System.out.println("What kind of user are you (parent or child)? or 'quit'");
			String userType = scan.nextLine().toLowerCase();
			
			if (userType.equals("parent"))
			{
				System.out.println("Please input your name: \n");
				String userName = scan.nextLine();
				for (Person user : users)
				{
					if (user.getName().equals(userName))
					{
						currentUser = user;
						break;
					}
				}
				if (currentUser == null)
				{
					currentUser = new Parent(userName);
					users.add(currentUser);
				}
				
				while(true)
				{
					System.out.println("\nPlease enter a command's letter from below:");
					System.out.println("(a) Add Child		(b) Edit Child		(c) Remove Child		(d) Set Child Mode");
					System.out.println("(e) Add Token		(f) Edit Token		(g) Remove Token		(h) Edit Periodic Tokens");
					System.out.println("(i) Add Reward		(j) Edit Reward		(k) Remove Reward		(l) Children Status");
					System.out.println("(m) Redeem Reward	(n) Change User		(o) Revert to old save		(p) Print User List");
					System.out.println("(q) Save		(r) Print History");
					
					String command = scan.nextLine();
					
					if (command.equals("a"))
					{
						String 	childName 	= promptForInput("Please enter a child name to add:");
						((Parent) currentUser).addChild(childName);
					}
					else if (command.equals("b"))
					{
						String 	childName 	= promptForInput("Please enter a child name to edit:");
						String 	newName 	= promptForInput("Please enter the childs new name:");
						((Parent) currentUser).editChild(childName, newName);
					}
					else if (command.equals("c"))
					{
						String 	childName 	= promptForInput("Please enter a child name:");
						((Parent) currentUser).deleteChild(childName);
					}
					else if (command.equals("d"))
					{
						String 	childName 	= promptForInput("Please enter a child name to change their mode:");
						Child 	currentChild= ((Parent) currentUser).getChild(childName);
						
						if (currentChild == null)
						{
							System.out.println("No such person");
							break;
						}
						System.out.println("This Childs current mode is: " + currentChild.getCurrentMode().getName());
						
						System.out.println("The Child has these modes:");
						for (Mode mode : currentChild.getModeList())
						{
							System.out.println(mode.getName());
						}
						
						String newModeString = promptForInput("Enter the name of the mode to change the child to: ");
						
						for (Mode mode : currentChild.getModeList())
						{
							if (newModeString.equals(mode.getName()))
							{
								currentChild.setMode(mode);
							}
						}
						System.out.println("This Childs current mode is now/still: " + currentChild.getCurrentMode().getName());
					}
					else if (command.equals("e"))
					{
						String 	childName 	= promptForInput("Please enter a child name to add token to:");
						String 	tokenName 	= promptForInput("Please enter a token name:");
						((Parent) currentUser).addToken(childName, tokenName);;
					}
					else if (command.equals("f"))
					{
						String 	childName 	= promptForInput("Please enter a child name to edit token from: ");
						String 	tokenName 	= promptForInput("Please enter a token name: ");
						String 	newTokenName= promptForInput("Please enter a new token name:");
						((Parent) currentUser).editToken(childName, tokenName, newTokenName);
					}
					else if (command.equals("g"))
					{
						String 	childName 	= promptForInput("Please enter a child name to delete token from:");
						String 	tokenName 	= promptForInput("Please enter a token name:");
						((Parent) currentUser).deleteToken(childName, tokenName);
					}
					else if (command.equals("h"))
					{
						String 	childName 	= promptForInput("Please enter a child name to add tokens to periodically:");
						int 	amount 		= promptForInputInt("Please enter an interger amount of tokens to add:");
						int 	time 		= promptForInputInt("Please enter an interger amount of seconds for the interval:");
						((Parent) currentUser).addTokenAccu(childName, amount, time);
					}
					else if (command.equals("i"))
					{
						System.out.println();
						String 	childName 	= promptForInput("Please enter a child name to add reward to:");
						String 	rewardName 	= promptForInput("Please enter a reward name:");
						int 	rewardCost 	= promptForInputInt("Please enter a reward cost:");
						((Parent) currentUser).addReward(childName, rewardName, rewardCost);
					}
					else if (command.equals("j"))
					{
						String 	childName 	= promptForInput("Please enter a child name to add reward to:");
						String 	rewardName 	= promptForInput("Please enter a reward name:");
						String 	newName 	= promptForInput("Please enter a new reward name:");
						int newRewardCost 	= promptForInputInt("Please enter a new reward cost:");
						((Parent) currentUser).editReward(childName, rewardName, newName, newRewardCost);
					}
					else if (command.equals("k"))
					{
						String 	childName	= promptForInput("Please enter a child name to delete reward from:");
						String 	rewardName 	= promptForInput("Please enter a reward name:");
						((Parent) currentUser).deleteReward(childName, rewardName);
					}
					else if (command.equals("l"))
					{
						((Parent) currentUser).childrenStatus();
					}
					else if (command.equals("m"))
					{
						String 	childName 	= promptForInput("Please enter a child name to redeem a reward from:");
						Child 	child 		= ((Parent) currentUser).getChild(childName);
						if (child == null)
						{
							System.out.println("No such person");
							break;
						}
						System.out.println(child.getName() + " is currently in " + child.getCurrentMode().getName() + " mode.");
						for(Reward reward : child.getCurrentMode().getRewards())
						{
							System.out.println("Costs: " + reward.getCost() + " -- Name: " + reward.getName());
						}
						String 	rewardName 	= promptForInput("Please enter a reward name to redeem:");
						int cost = child.getCurrentMode().redeemReward(rewardName, child.getCurrentMode().getTokens().size());
						
						for (int i = 0; i < cost; i++)
						{
							child.tokenStatus();
							System.out.println("\nEnter the name of a token to expend: ");
							String checker = scan.nextLine();
							child.getCurrentMode().deleteToken(checker);
						}
					}
					else if (command.equals("n"))
					{
						currentUser= null;
						break;
					}
					else if (command.equals("o"))
					{
						users.clear();
						String 	fileName	= promptForInput("Please enter a file name to read from:");
						users = fh.readFromFile(fileName);
						currentUser= null;
						break;
					}
					else if (command.equals("p"))
					{
						for (int i = 0; i < users.size(); i++)
						{
							System.out.println(i + ". " + users.get(i).getName());
						}
					}
					else if (command.equals("q"))
					{
						String 	fileName	= promptForInput("Please enter a file name to save to:");
						fh.saveToFile(fileName, users);
					}
					else if (command.equals("r"))
					{
						String 	childName	= promptForInput("Please enter a child name to generate history graphs for:");
						int 	interval	= promptForInputInt("Please enter the amount of intervals the graphs should have:");
						Child 	child 		= ((Parent) currentUser).getChild(childName);
						ch.setInterval(interval);
						try 
						{
							ch.makeChart(child);
						} 
						catch (IOException e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("Incorrect Entry");
					}
				}
			}
			
			else if (userType.equals("child"))
			{
				String userName = promptForInput("Please input your name: ");
				
				if(users.size() == 0)
				{
					System.out.println("There are no Children entered!");
				}
				else
				{
					for(Person user : users)
					{
						for (Child child: ((Parent) user).getchildren())
						{
							if(child.getName().toLowerCase().equals(userName.toLowerCase()))
							{
								while(true)
								{
									System.out.println("\nPlease enter a command's letter from below:");
									System.out.println("(a) View Token Status		(b) Redeem Tokens		(c) Change User\n");
									String command = scan.nextLine();
									
									if (command.equals("a"))
									{
										child.tokenStatus();
									}
									
									else if (command.equals("b"))
									{
										for(Mode mode: child.getModeList())
										{
											if (mode.getName().equals("POSITIVE"))
											{
												System.out.println("\nCurrent " + mode.getName() + " Rewards:");
												int counter = 0;
												if(mode.getRewards().size() != 0)
												{
													for(Reward reward : mode.getRewards())
													{
														System.out.println(counter + ".  Costs: " + reward.getCost() + " -- Name: " + reward.getName());
														counter++;
													}
													
													System.out.println("Enter the name of the reward to be redeemed: ");
													
													String choice = scan.nextLine();									
													int cost = mode.redeemReward(choice, mode.getTokens().size());
													
													for (int i = 0; i < cost; i++)
													{
														child.tokenStatus();
														System.out.println("\nEnter the name of a token to expend: ");
														String checker = scan.nextLine();
														mode.deleteToken(checker);
													}
													
													System.out.println("You now have " + mode.getTokens().size() + " tokens left.");
													break;
												}
												else
												{
													System.out.println("There are no rewards to be redeemed yet!");
												}
											}
										}
									}
									else if(command.equals("c"))
									{
										break;
									}
									else
									{
										System.out.println("Incorrect Entry");
									}
								}
							}
							else
							{
								System.out.println("There are no Children by that name!");
							}
						}
					}
				}
			}
			else if (userType.toLowerCase().equals("quit"))
			{
				break;
			}
			else
			{
				System.out.println("That is not a currently Supported user!");
			}
		}
	}
	
	public String promptForInput(String prompt)
	{
		System.out.println(prompt);
		String message = scan.nextLine();
		return message;
	}
	
	public int promptForInputInt(String prompt)
	{
		System.out.println(prompt);
		int message = scan.nextInt();
		return message;
	}
}