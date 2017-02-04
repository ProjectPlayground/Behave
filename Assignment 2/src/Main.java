import java.util.ArrayList;
import java.util.Scanner; 

public class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<Person> users = new ArrayList<Person>();
		Person currentUser;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("What kind of user are you?");
			String userType = scan.nextLine().toLowerCase();
			
			if (userType.equals("parent"))
			{
				System.out.println("You are a Parent.");
				System.out.println("Please input your name: ");
				currentUser = new Parent(scan.nextLine());
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
						System.out.println("Please enter a child name:");
						String childName = scan.nextLine();
						((Parent) currentUser).addChild(childName);
					}
					else if (command.equals("b"))
					{
						System.out.println("Please enter a child name:");
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
						System.out.println("Please enter a child name:");
						String childName = scan.nextLine();
						Child currentChild = ((Parent) currentUser).getChild(childName);
						System.out.println("This Childs current mode is:");
						System.out.println(currentChild.getCurrentMode().getName());
						
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
						System.out.println("This Childs current mode is now: " + currentChild.getCurrentMode().getName());
					}
					else if (command.equals("e"))
					{
						
					}
					else if (command.equals("f"))
					{
						
					}
					else if (command.equals("g"))
					{
						
					}
					else if (command.equals("h"))
					{
						
					}
					else if (command.equals("i"))
					{
						
					}
					else if (command.equals("j"))
					{
						
					}
					else if (command.equals("k"))
					{
						
					}
					else if (command.equals("l"))
					{
						
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
						ArrayList<Child> currentChildren = ((Parent) user).getchildren();
						for (Child child: currentChildren)
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
												for(Reward reward : mode.getRewards())
												{
													System.out.println(counter + ".  Costs: " + reward.getCost() + " -- " + reward.getName());
													counter++;
												}
												System.out.println("Enter the number of the reward to be redeemed: ");
												int choice = scan.nextInt();
												
												System.out.println("You redeemed " + mode.getRewards().get(choice) + " for a cost of " + mode.getRewards().get(choice).getCost());
												
												int cost = mode.getRewards().get(choice).getCost();
												
												for (int i = 0; i < cost; i++)
												{
													mode.getTokens().remove(i);
												}
												System.out.println("You now have " + mode.getTokens().size() + " tokens left.");
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
