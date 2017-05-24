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
	String[] countries = line.split("\\|");
	HashMap<Integer,ArrayList<Integer>> teamsInfo = new HashMap<Integer,ArrayList<Integer>>();
	
	for (int i=0;i<countries.length;i++)
	{
		String[] teams = countries[i].trim().split(" ");
		for (int j=0;j<teams.length;j++)
		{
			int team = Integer.parseInt(teams[j]);
			if (teamsInfo.containsKey(team))
			{
				teamsInfo.get(team).add(i+1);
			}
			else
			{
				ArrayList<Integer> teamCountries = new ArrayList<Integer>();
				teamCountries.add(i+1);
				teamsInfo.put(team,teamCountries);
			}
		}
	}
	
	StringBuilder res = new StringBuilder();
	teamsInfo.keySet().stream().sorted().forEach(x ->
	{
		res
				.append(x)
				.append(":");
		teamsInfo.get(x).forEach(y -> res.append(y).append(","));
		res.setLength(res.length()-1);
		res.append("; ");
	});
	
	return res.toString();
}
}