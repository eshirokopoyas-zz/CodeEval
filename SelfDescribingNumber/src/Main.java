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
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(isHappyNumber(line));
        }
    }
    private static int isHappyNumber(String number)
    {
        int res=1;
        int counter=0;
        char[] digits = number.toCharArray();
        for (int i=0;i<digits.length;i++)
        {
            counter=0;
            for (int j=0;j<digits.length;j++)
            {
                if (digits[j]-'0'==i) counter++;
            }
            if (counter!=digits[i]-'0')
            {
                res=0;
                break;
            }
        }
        return res;
    }
}