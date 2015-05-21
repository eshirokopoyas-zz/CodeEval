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
            System.out.println(hexStringToDecNumber(line));
        }
    }
    private static int hexStringToDecNumber(String hex)
    {
        int res=0;
        char[] digits = hex.toCharArray();
        for (int i=digits.length-1;i>-1;i--)
        {
            res+=hexDigitToDecDigit(digits[i])*Math.pow(16,digits.length-1-i);
        }
        return res;
    }
    private static int hexDigitToDecDigit(char digit)
    {
        switch (digit)
        {
            case '0':return 0;
            case '1':return 1;
            case '2':return 2;
            case '3':return 3;
            case '4':return 4;
            case '5':return 5;
            case '6':return 6;
            case '7':return 7;
            case '8':return 8;
            case '9':return 9;
            case 'a':return 10;
            case 'b':return 11;
            case 'c':return 12;
            case 'd':return 13;
            case 'e':return 14;
            case 'f':return 15;
        }
        return 0;
    }
}