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
        char[] digits;
        int sum;
        while ((line = bufferedReader.readLine()) != null)
        {
            sum=0;
            digits = line.toCharArray();
            for (int i=0;i<digits.length;i++)
            {
                sum+=digits[i]-'0';
            }
            System.out.println(sum);
        }
    }
}
