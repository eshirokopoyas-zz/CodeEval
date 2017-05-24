import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

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
	String[] numbersString = params[0].split(" ");
	int[] numbers = new int[numbersString.length];
	for (int i=0;i<numbersString.length;i++)
	{
		numbers[i]=Integer.parseInt(numbersString[i]);
	}
	
	StringBuilder res = new StringBuilder();
	
	int iterations = Integer.parseInt(params[1].trim());
	
	int count=0;
	int temp;
 
    A:
	while (count<iterations)
	{
		for (int i=0;i<numbersString.length-1;i++)
		{
			if (numbers[i]>numbers[i+1])
			{
				temp=numbers[i];
				numbers[i]=numbers[i+1];
				numbers[i+1]=temp;
				count++;
				continue A;
			}
		}
		break;
	}
	
	for (int i=0;i<numbersString.length;i++)
	{
		res.append(numbers[i]);
		res.append(" ");
	}
	
	
	return res.toString();
}
}