import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by eshirokopoyas on 27.05.2015.
 */
public class Main
{
    public static Calendar calendar = Calendar.getInstance();
    public static void main(String[] args) throws IOException
    {


        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
//        File file = new File(args[0]);
        File file = new File("c:\\1\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(line);
        }
    }

    class DateInterval
    {
        Calendar start;
        Calendar end;
        public DateInterval(Calendar a, Calendar b)
        {
            this.start=a;
            this.end=b;
            this.end.add(Calendar.DAY_OF_MONTH,this.end.getActualMaximum(Calendar.DAY_OF_MONTH));

        }

        public boolean areCrossed(DateInterval dateInterval)
        {
            return !(this.start.after(dateInterval.end)||this.end.before(dateInterval.start));
        }

        public DateInterval merge(DateInterval dateInterval)
        {
            if (this.start.after(dateInterval.start))
                return new DateInterval(dateInterval.start,this.end);
            else
            {
                return new DateInterval(this.start,dateInterval.end);
            }
        }
    }
}