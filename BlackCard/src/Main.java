import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by eshirokopoyas on 20.05.2015.
 */
public class Main
{
public static void main(String[] args) throws IOException
{
	File file = new File(args[0]);
//	File file = new File("C:\\1\\1.txt");
	BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	String line;
	
	while ((line = bufferedReader.readLine()) != null)
	{
		System.out.println(processLine(line));
	}
}

private static String processLine(String line)
{
	String[] params = line.split("\\|");
	ArrayList<String> personList = new ArrayList<String>(Arrays.asList(params[0].trim().split(" ")));
	int iterations = Integer.parseInt(params[1].trim());
	int counter=0;
	while (personList.size()>1)
	{
		for (int i=0;i<personList.size();i++)
		{
			if (++counter==iterations)
			{
				personList.remove(i);
				counter=0;
				break;
			}
		}
	}
	return personList.get(0);
}
}