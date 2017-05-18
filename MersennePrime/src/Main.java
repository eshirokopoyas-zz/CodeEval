import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by eshirokopoyas on 22.05.2015.
 */
public class Main
{
	
	private static int multiplier = 2;
	
	private static int counter = 1;
	
	private static StringBuilder stringBuilder = new StringBuilder();
	
	private static final String DELIMITER = ", ";
	
public static void main(String[] args) throws IOException
{
    File file = new File(args[0]);
    
//    File file = new File("C:\\1\\1.txt");
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line;
    
    while ((line = bufferedReader.readLine()) != null)
    {
        System.out.println(processLine(line));
        stringBuilder.setLength(0);
        multiplier=2;
        counter=1;
    }
	
}

private static String processLine(String line)
{
	int res = getNextMersenneNumber();
	int limit =  Integer.parseInt(line);
	stringBuilder.append(res);
	while ((res=getNextMersenneNumber())<limit)
	{
		stringBuilder.append(DELIMITER);
		stringBuilder.append(res);
	}
	return stringBuilder.toString();
}

private static int getNextMersenneNumber()
{
	multiplier*=2;
	counter+=1;
	int res = multiplier-1;
	if (isPrime(counter))
		return res;
	else
		return getNextMersenneNumber();
}

private static boolean isPrime(int n)
{
	boolean res=true;
	for (int i=2;i<n;i++)
	{
		res&=!(n%i==0);
	}
	return res;
}
}

 
