import java.util.ArrayList;
import java.util.Scanner; 

public class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<Person> users = new ArrayList<Person>();
		Person currentUser = null;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("What kind of user are you?");
			String userType = scan.nextLine().toLowerCase();
			
			if (userType.equals("parent"))
			{
				System.out.println("You are a Parent.");
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
				}
				
				while(true)
				{
					System.out.println("\nPlease enter a command's letter from below:");
					System.out.println("(a) Add Child		(b) Edit Child		(c) Remove Child		(d) Set Child Mode");
					System.out.println("(e) Add Token		(f) Edit Token		(g) Remove Token		(h) Edit Periodic Tokens");
					System.out.println("(i) Add Reward		(j) Edit Reward		(k) Remove Reward		(l) Children Status");
					System.out.println("(m) Change User");
					
					String command = scan.nextLine();
					
					if (command.equals("a"))
					{
						System.out.println("Please enter a child name to add:");
						String childName = scan.nextLine();
						((Parent) currentUser).addChild(childName);
					}
					else if (command.equals("b"))
					{
						System.out.println("Please enter a child name to edit:");
						String childName = scan.nextLine();
						System.out.println("Please enter the childs new name:");
						String newName = scan.nextLine();
						((Parent) currentUser).editChild(childName, newName);
					}
					else if (command.equals("c"))
					{
						System.out.println("Please enter a child name:");
						String childName = scan.nextLine();
						((Parent) currentUser).deleteChild(childName);
					}
					else if (command.equals("d"))
					{
						System.out.println("Please enter a child name to change their mode:");
						String childName = scan.nextLine();
						Child currentChild = ((Parent) currentUser).getChild(childName);
						System.out.println("This Childs current mode is: " + currentChild.getCurrentMode().getName());
						
						System.out.println("The Child has these modes:");
						for (Mode mode : currentChild.getModeList())
						{
							System.out.println(mode.getName());
						}
						
						System.out.println("Enter the name of the mode to change the child too: ");
						String newModeString = scan.nextLine();
						
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
						System.out.println("Please enter a child name to add token to:");
						String childName = scan.nextLine();
						System.out.println("Please enter a token name:");
						String tokenName = scan.nextLine();
						((Parent) currentUser).addToken(childName, tokenName);;
					}
					else if (command.equals("f"))
					{
						System.out.println("Please enter a child name to edit token from:");
						String childName = scan.nextLine();
						System.out.println("Please enter a token name:");
						String tokenName = scan.nextLine();
						System.out.println("Please enter a new token name:");
						String newTokenName = scan.nextLine();
						
						((Parent) currentUser).editToken(childName, tokenName, newTokenName);
					}
					else if (command.equals("g"))
					{
						System.out.println("Please enter a child name to delete token from:");
						String childName = scan.nextLine();
						System.out.println("Please enter a token name:");
						String tokenName = scan.nextLine();
						((Parent) currentUser).deleteToken(childName, tokenName);
					}
					else if (command.equals("h"))
					{
						System.out.println("Please enter a child name to add tokens to periodically:");
						String childName = scan.nextLine();
						System.out.println("Please enter an interger amount of tokens to add:");
						int amount = scan.nextInt();
						((Parent) currentUser).addTokenAccu(childName, amount);
					}
					else if (command.equals("i"))
					{
						System.out.println("Please enter a child name to add reward to:");
						String childName = scan.nextLine();
						System.out.println("Please enter a reward name:");
						String rewardName = scan.nextLine();
						System.out.println("Please enter a reward cost:");
						int rewardCost = scan.nextInt();
						((Parent) currentUser).addReward(childName, rewardName, rewardCost);
					}
					else if (command.equals("j"))
					{
						System.out.println("Please enter a child name to add reward to:");
						String childName = scan.nextLine();
						System.out.println("Please enter a reward name:");
						String rewardName = scan.nextLine();
						System.out.println("Please enter a new reward name:");
						String newRewardName = scan.nextLine();
						System.out.println("Please enter a new reward cost:");
						int newRewardCost = scan.nextInt();
						((Parent) currentUser).editReward(childName, rewardName, newRewardName, newRewardCost);
					}
					else if (command.equals("k"))
					{
						System.out.println("Please enter a child name to delete reward from:");
						String childName = scan.nextLine();
						System.out.println("Please enter a reward name:");
						String rewardName = scan.nextLine();
						((Parent) currentUser).deleteReward(childName, rewardName);
					}
					else if (command.equals("l"))
					{
						for (Child child : ((Parent) currentUser).getchildren())
						{
							System.out.println("Current Child: " + child.getName());
							for (Mode mode : child.getModeList())
							{
								System.out.println(mode.getName());
								System.out.println("____________________");
								System.out.println("	Tokens  | " + mode.getTokens().size());
								System.out.println("	Rewards | " + mode.getRewards().size()+ "\n");
							}
						}
						
					}
					else if (command.equals("m"))
					{
						users.add(currentUser);
						break;
					}
					else
					{
						System.out.println("Incorrect Entry");
					}
				}
			}
			
			else if (userType.equals("child"))
			{
				System.out.println("Please input your name: ");
				String userName = scan.nextLine();
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
							if(child.getName().equals(userName))
							{
								while(true)
								{
									System.out.println("\nPlease enter a command's letter from below:");
									System.out.println("(a) View Token Status		(b) Redeem Tokens		(c) Change User\n");
									String command = scan.nextLine();
									
									if (command.equals("a"))
									{
										for(Mode mode : child.getModeList())
										{
											System.out.println("\nCurrent " + mode.getName() + " Tokens: " + mode.getTokens().size());
											for(Token token :mode.getTokens())
											{
												System.out.println(token.getName() + " " + token.getTimeStamp());
											}
										}
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
														System.out.println(counter + ".  Costs: " + reward.getCost() + " -- " + reward.getName());
														counter++;
													}
													System.out.println("Enter the number of the reward to be redeemed: ");
													int choice = scan.nextInt();
													if (choice >= mode.getRewards().size())
													{
														System.out.println("Invalid Input");
														break;
													}
													
													System.out.println("You redeemed " + mode.getRewards().get(choice) + " for a cost of " + mode.getRewards().get(choice).getCost());
													
													int cost = mode.getRewards().get(choice).getCost();
													
													for (int i = 0; i < cost; i++)
													{
														mode.getTokens().remove(i);
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
			else
			{
				System.out.println("That is not a currently Supported user!");
			}
		}
	}
}
