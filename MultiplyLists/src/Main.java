import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 26.05.2015.
 */
public class Main
{
    private static String[] lists;
    private static String[] list1;
    private static String[] list2;
    private static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException
    {
        stringBuilder = new StringBuilder();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            lists=line.split(" \\| ");
            list1=lists[0].split(" ");
            list2=lists[1].split(" ");
            for (int i=0;i<list1.length;i++)
            {
                stringBuilder.append(Integer.valueOf(list1[i])*Integer.valueOf(list2[i]));
                if (i!=list1.length-1)
                {
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder);
            stringBuilder.setLength(0);
        }
    }
}