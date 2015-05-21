import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eshirokopoyas on 19.05.2015.
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
        ArrayList<Integer> numberHistory = new ArrayList<Integer>();
        int res=Integer.valueOf(number);

        while (!numberHistory.contains(res))
        {
            numberHistory.add(res);
            res=getNext(res);
        }
        switch (res)
        {
            case 1:return 1;
            default:return 0;
        }
    }
    private static int getNext(int n)
    {
        if (n<10) return n*n;
        String number = String.valueOf(n);
        char[] digits=number.toCharArray();
        int res=0;
        for (int i=0;i<digits.length;i++)
        {
            res+=(digits[i]-'0')*(digits[i]-'0');
        }
        return res;
    }
}