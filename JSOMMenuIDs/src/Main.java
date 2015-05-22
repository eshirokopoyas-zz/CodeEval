import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eshirokopoyas on 21.05.2015.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(getSumOfLabelIDs(line));
        }
    }
    private static int getSumOfLabelIDs(String line)
    {
        Pattern p=Pattern.compile("Label \\d+");
        Matcher m = p.matcher(line);
        int sum=0;
        while (m.find())
        {
            sum+=Integer.valueOf(m.group().substring(6));
        }
        return sum;
    }
}