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
	line=line.replace(" ","");
	String[] params = line.split("\\|");
	char[] string1 = params[0].trim().toCharArray();
	char[] string2 = params[1].trim().toCharArray();
	int res =0;
	for (int i=0;i<string1.length;i++)
	{
		if (string1[i]!=string2[i])
			res++;
	}
	
	if (res==0)
		return "Done";
	if (res<3)
		return "Low";
	if (res<5)
		return "Medium";
	if (res<7)
		return "High";
	
	return "Critical";
	
}
}