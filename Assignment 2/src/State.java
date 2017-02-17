import java.util.ArrayList;
import java.util.Date;

public class State 
{
	ArrayList<Person> userStates;
	Date timeStamp;
	
	public State(ArrayList<Person> users)
	{
		this.userStates = new ArrayList<Person>(users);
		timeStamp = new Date();
	}
	
	public ArrayList<Person> getSavedState()
	{
		return userStates;
	}
	public Date getTimeStamp()
	{
		return timeStamp;
	}
	
}
