import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        String[] lists;
        StringBuilder res = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null)
        {
            lists=line.split(";");
            System.out.println(getInterceptionElements(lists[0],lists[1],res));
            res.setLength(0);
        }
    }
    private static StringBuilder getInterceptionElements(String list1, String list2, StringBuilder res)
    {
        String[] list1Elements = list1.split(",");
        String[] list2Elements = list2.split(",");
        for (int i=0;i<list1Elements.length;i++)
        {
            for (int j=0;j<list2Elements.length;j++)
            {
                if (list1Elements[i].equals(list2Elements[j]))
                {
                    res.append(list1Elements[i]);
                    res.append(',');
                }
            }
        }
        if (res.length()>0)
        {
            res.deleteCharAt(res.length()-1);
        }

        return res;
    }
}