import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 22.05.2015.
 */
public class Main
{
    public static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException
    {
        stringBuilder=new StringBuilder();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            wordToDigit(line.split(";"));
            System.out.println(stringBuilder);
            stringBuilder.setLength(0);
        }
    }
    private static void wordToDigit(String[] digits)
    {
        for (int i=0;i<digits.length;i++)
        {
            switch (digits[i])
            {
                case "zero":stringBuilder.append(0);break;
                case "one":stringBuilder.append(1);break;
                case "two":stringBuilder.append(2);break;
                case "three":stringBuilder.append(3);break;
                case "four":stringBuilder.append(4);break;
                case "five":stringBuilder.append(5);break;
                case "six":stringBuilder.append(6);break;
                case "seven":stringBuilder.append(7);break;
                case "eight":stringBuilder.append(8);break;
                case "nine":stringBuilder.append(9);break;
            }
        }
    }
}
