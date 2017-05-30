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

private static int processLine(String line)
{
	String[] params = line.split(", ");
	int res = 0;
	int count =0;
	for (int i=0;i<params.length;i++)
	{
		String[] atr = params[i].split(": ");
		int quantity = Integer.parseInt(atr[1]);
		if (i==params.length-1)
		{
			res*=quantity;
			break;
		}
		res+=getMultiplier(atr[0])*quantity;
		count+=quantity;

	}
	
	return res/count;
}

private static int getMultiplier(String monster)
{
	switch (monster)
	{
		case "Vampires":return 3;
		case "Zombies":return 4;
		default: return 5;
	}
}
}