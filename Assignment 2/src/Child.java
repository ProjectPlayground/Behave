import java.util.ArrayList;

public class Child extends Person 
{
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
	
	/* Getters */
	public TokenManager getManager()
	{
		return manager;
	}
	
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
