import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalField;
import java.util.*;

/**
 * Created by eshirokopoyas on 20.05.2015.
 */
public class Main
{
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
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
	String[] timeStrings = line.split(" ");
	LinkedList<LocalTime> localTimes = new LinkedList<LocalTime>();
	StringBuilder stringBuilder = new StringBuilder();
	
	for (int i=0; i<timeStrings.length;i++)
	{
		LocalTime localTime = LocalTime.parse(timeStrings[i],dateTimeFormatter);
		localTimes.add(localTime);
	}
	
	localTimes.sort(LocalTime::compareTo);
	localTimes.descendingIterator().forEachRemaining(x -> {
		stringBuilder.append(dateTimeFormatter.format(x)).append(" ");
	});
	return stringBuilder.toString().trim();
}

}