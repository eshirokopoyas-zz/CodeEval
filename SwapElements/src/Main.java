import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 26.05.2015.
 */
public class Main
{
    private static String[] numbers;
    private static String[] swapIndexes;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException
    {
        stringBuilder = new StringBuilder();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String[] params;
        String[] indexes;
        while ((line = bufferedReader.readLine()) != null)
        {
            params=line.split(" : ");
            numbers=params[0].split(" ");
            swapIndexes=params[1].split(", ");
            for (String item:swapIndexes)
            {
                indexes=item.split("-");
                swapElements(Integer.valueOf(indexes[0]),Integer.valueOf(indexes[1]));
            }
            for (int i=0;i<numbers.length;i++)
            {
                stringBuilder.append(numbers[i]);
                if (i!=numbers.length-1)
                {
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder);
            stringBuilder.setLength(0);
        }
    }
    private static void swapElements(int i, int j)
    {
        String temp;
        temp = numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=temp;
    }

}