import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 22.05.2015.
 */
public class Main
{
    public static char[] decimals={'I','X','C','M'};
    public static char[] decimalsFives={'V','L','D'};
    public static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException
    {
        stringBuilder=new StringBuilder();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            formRomanNumber(line);
            System.out.println(stringBuilder);
            stringBuilder.setLength(0);
        }
    }
    private static void formRomanNumber(String number)
    {
        int temp;
        char[] digits = number.toCharArray();
        for (int i=0;i<digits.length;i++)
        {
            switch (digits[i])
            {
                case '9':
                {
                    stringBuilder.append(decimals[number.length()-i-1]);
                    stringBuilder.append(decimals[number.length()-i]);
                    break;
                }
                case '4':
                {
                    stringBuilder.append(decimals[number.length()-i-1]);
                    stringBuilder.append(decimalsFives[number.length()-i-1]);
                    break;
                }
                case '5':
                {
                    stringBuilder.append(decimalsFives[number.length()-i-1]);
                    break;
                }
                default:
                {
                    temp=digits[i]-'0';
                    if (temp<5)
                    {
                        for (int j=0;j<digits[i]-'0';j++)
                        {
                            stringBuilder.append(decimals[number.length()-i-1]);
                        }
                    }
                    else
                    {
                        stringBuilder.append(decimalsFives[number.length()-i-1]);
                        for (int k=5;k<temp;k++)
                        {
                            stringBuilder.append(decimals[number.length()-i-1]);
                        }
                    }

                    break;
                }
            }
        }
    }
}