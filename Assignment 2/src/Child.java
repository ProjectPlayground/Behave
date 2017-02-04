public class Child extends Person 
{
	/* Variables */
	protected TokenManager manager;
	protected Mode currentMode;
	
	/* Constructors */
	public Child(String name, TokenManager manager) 
	{
		super(name);
		this.manager = manager; 
	}
	
	/* Getters */
	public TokenManager getManager()
	{
		return manager;
	}
	
	public Mode getMode()
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
