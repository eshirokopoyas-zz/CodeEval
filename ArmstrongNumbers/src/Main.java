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
        String[] params;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(isArmstrongNumber(line));
        }
    }
    private static String isArmstrongNumber(String number)
    {
        String res;
        int sum=0;
        char[] digits = number.toCharArray();
        for (int i=0;i<digits.length;i++)
        {
            sum+=Math.pow(digits[i] - '0', digits.length);
        }
        res=sum==Integer.valueOf(number)?"True":"False";
        return res;
    }
}