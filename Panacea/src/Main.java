import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
		if (processLine(line))
			System.out.println("True");
		else
			System.out.println("False");
	}
	
}
	private static boolean processLine(String line)
	{
		int hexSum=0;
		int binSum=0;
		
		String[] parts = line.split("\\|");
		String hexNumbers = parts[0].trim();
		String binNumbers = parts[1].trim();
		
		String[] hexes = hexNumbers.split(" ");
		String[] BINs = binNumbers.split(" ");
		
		
		for (int i=0;i<hexes.length;i++)
		{
			hexSum+=Integer.parseInt(hexes[i],16);
		}
		for (int j=0;j<BINs.length;j++)
		{
			binSum+=Integer.parseInt(BINs[j],2);
		}
	return hexSum<=binSum;
	
	}
}