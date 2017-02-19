import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler 
{
	FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fis;
	ObjectInputStream ois;
	
	public FileHandler()
	{
	}
	
	public void saveToFile(String fileName, ArrayList<Person> users)
	{
		try 
		{
			fos = new FileOutputStream(fileName+ ".ser");
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		try 
		{
			oos = new ObjectOutputStream(fos);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			oos.writeObject(users);
			oos.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Person> readFromFile(String fileName)
	{
		ArrayList<Person> users = null;
		try 
		{
			fis = new FileInputStream(fileName + ".ser");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			ois = new ObjectInputStream(fis);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			users = (ArrayList<Person>) ois.readObject();
			ois.close();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		
		return users;
	}
}
