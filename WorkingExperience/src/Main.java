import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Stream;

/** TEST
 * Created by eshirokopoyas on 27.05.2015.
 */
public class Main
{
    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MMM yyyy").parseDefaulting(ChronoField.DAY_OF_MONTH,1).toFormatter(Locale.ENGLISH);

    private static final String DELIMITER1="-";
    private static final String DELIMITER2=";";

    public static void main(String[] args) throws IOException
    {
//        File file = new File(args[0]);


        File file = new File("c:\\1\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(line.trim());
        }
    }

    private static int getMonth(String line)
    {
        List<DateInterval> dateIntervalList = new ArrayList<>();
        for (String string:line.split(DELIMITER2))
        {
            dateIntervalList.add(new DateInterval(string));
        }
        return 0;
    }

    private static class DateInterval
    {
        private LocalDate start;
        private LocalDate end;

        private DateInterval(LocalDate start, LocalDate end)
        {
            this.start = start;
            this.end = end;
        }

        private DateInterval(String interval)
        {
            String[] dates = interval.split(DELIMITER1);
            this.start=parse(dates[0]);
            this.end=parse(dates[1]).plus(1,ChronoUnit.MONTHS).minus(1,ChronoUnit.DAYS);
        }

        @Override
        public String toString()
        {
            return "start: " + start + ", end: " + end;
        }

        public long getMonths()
        {
            return Period.between(start,end.plus(1,ChronoUnit.DAYS)).toTotalMonths();
        }

        public boolean isNotIntersectedWith(DateInterval dateInterval)
        {
            return this.start.isAfter(dateInterval.end)
                    ||this.end.isBefore(dateInterval.start);
        }

        public boolean isAdjoinWith(DateInterval dateInterval)
        {
            return this.start.isEqual(dateInterval.end)
                    ||this.end.isEqual(dateInterval.start);
        }

        public DateInterval mergeIntervals(DateInterval dateInterval1, DateInterval dateInterval2)
        {
            return new DateInterval(dateInterval1.start.isBefore(dateInterval2.start)?dateInterval1.start:dateInterval2.start,dateInterval1.end.isAfter(dateInterval2.end)?dateInterval1.end:dateInterval2.end);
        }
    }

    private static LocalDate parse(String date)
    {
        return LocalDate.parse(date, formatter);
    }
}