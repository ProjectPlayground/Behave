import java.util.ArrayList;

public class Child extends Person 
{

	private static final long serialVersionUID = 1117307613625852055L;
	/* Variables */
	protected ArrayList<Mode> modes = new ArrayList<Mode>();
	protected TokenManager manager;
	protected Mode currentMode;
	
	/* Constructors */
	public Child(String name, TokenManager manager) 
	{
		super(name);
		this.manager = manager;
		for (String type : DefaultModes.names())
		{
			modes.add(new Mode(type));
		}
		
		for (Mode mode : modes)
		{
			if (mode.getName().equals("POSITIVE"))
			{
				currentMode = mode;
			}
		}
	}
	
	/* Methods */
	public void tokenStatus()
	{
		for(Mode mode : modes)
		{
			System.out.println("\nCurrent " + mode.getName() + " Tokens: " + mode.getTokens().size());
			for(Token token :mode.getTokens())
			{
				System.out.println(token.getName() + " " + token.getTimeStamp());
			}
		}
	}
	
	/* Getters */
	public ArrayList<Mode> getModeList()
	{
		return modes;
	}
	
	public Mode getCurrentMode()
	{
		return currentMode;
	}
	
	/* Setters */
	public void setManager(TokenManager manager)
	{
		this.manager = manager;
	}
	
	public void setMode(Mode mode)
	{
		this.currentMode = mode;
	}

}
