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
	char[] symbols = line.replace(" ","").toCharArray();
	int res =0;
	for (int i=0;i<symbols.length;i++)
	{
			int num = Character.getNumericValue(symbols[i]);
			if (i%2==0)
				res+=num*2;
			else
				res+=num;
	}
	
	if (res%10==0)
	{
		return "Real";
	}
	return "Fake";
}
}