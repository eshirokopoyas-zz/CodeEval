import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 18.05.2015.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        int sum=0;
        while ((line = bufferedReader.readLine()) != null)
        {
            sum+=Integer.valueOf(line);
        }
        System.out.println(sum);
    }
}