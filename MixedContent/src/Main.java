import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 26.05.2015.
 */
public class Main
{
    private static StringBuilder stringBuilderWord;
    private static StringBuilder stringBuilderNumber;
    private static String[] elements;
    public static void main(String[] args) throws IOException
    {
        stringBuilderWord=new StringBuilder();
        stringBuilderNumber=new StringBuilder();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {

            if (line.matches("^\\d+(,\\d+)+?$"))
            {
                System.out.println(line);
                continue;
            }

            if (line.matches("^\\p{Alpha}+(,\\p{Alpha}+)+?$"))
            {
                System.out.println(line);
                continue;
            }

            elements=line.split(",");
            for (int i=0;i<elements.length;i++)
            {
                if (elements[i].matches("\\d+"))
                {
                    stringBuilderNumber.append(elements[i]);
                    stringBuilderNumber.append(',');
                }
                else
                {
                    stringBuilderWord.append(elements[i]);
                    stringBuilderWord.append(',');
                }

            }
            stringBuilderWord.deleteCharAt(stringBuilderWord.length()-1);
            stringBuilderNumber.deleteCharAt(stringBuilderNumber.length() - 1);
            System.out.println(stringBuilderWord.append("|").append(stringBuilderNumber));
            stringBuilderNumber.setLength(0);
            stringBuilderWord.setLength(0);
        }
    }
}