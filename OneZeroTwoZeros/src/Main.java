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
	String[] params = line.split(" ");
	int res =0;
	int numbersCount = Integer.parseInt(params[0]);
	int binNumbers = Integer.parseInt(params[1]);
	
	for (;binNumbers>0;binNumbers--)
	{
		BitSet bitSet = new BitSet();
		for (int temp=binNumbers, i=0;temp!=0;temp=temp>>>1,i++)
			if (temp%2!=0)
				bitSet.set(i);
		if (bitSet.length()-bitSet.cardinality()==numbersCount)
			res++;
		
	}
	
	return res;
}

}