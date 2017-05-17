import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.BitSet;
import java.util.Locale;

/** TEST
 * Created by eshirokopoyas on 27.05.2015.
 */
public class Main
{
    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MMM yyyy").parseDefaulting(ChronoField.DAY_OF_MONTH,1).toFormatter(Locale.ENGLISH);

    private static final String DELIMITER1="-";
    private static final String DELIMITER2="; ";
    
    private static final LocalDate zero = LocalDate.of(1990,1,1);

    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);


//        File file = new File("c:\\1\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(processLine(line));
        }
    }

    private static class DateInterval
    {
	    private LocalDate start;
	    private LocalDate end;
	    
	    private DateInterval(String interval)
	    {
		    String[] dates = interval.split(DELIMITER1);
		    this.start = parse(dates[0]);
		    this.end = parse(dates[1]).plus(1,ChronoUnit.DAYS);
	    }
	
	    @Override
	    public String toString()
	    {
		    return "start: " + start + ", end: " + end;
	    }
    }
    
    private static int processLine(String line)
    {
    	BitSet bitSet = new BitSet(360);
    	
    	for (String intervalString:line.split(DELIMITER2))
	    {
		    DateInterval dateInterval = new DateInterval(intervalString);
		    int startMonth = (int) Period.between(zero,dateInterval.start).toTotalMonths();
		    int endMonth = (int) Period.between(zero,dateInterval.end).toTotalMonths();
		    bitSet.set(startMonth,endMonth+1);
	    }
    	return bitSet.cardinality()/12;
    }

    private static LocalDate parse(String date)
    {
        return LocalDate.parse(date, formatter);
    }
}