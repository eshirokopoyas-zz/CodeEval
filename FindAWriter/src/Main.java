import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 21.05.2015.
 */
public class Main
{
    public static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException
    {
//        File file = new File(args[0]);
        File file = new File("c:\\1\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String[] params;
        stringBuilder=new StringBuilder();
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(line);
            params=line.split("|");
            System.out.println(getEncodedWriter(params[0], params[1].trim(), stringBuilder));

            stringBuilder.setLength(0);

        }
    }
    private static StringBuilder getEncodedWriter(String dict, String key,StringBuilder res)
    {
        for (String item:key.split(" "))
        {
            res.append(dict.charAt(Integer.valueOf(item)));
        }
        return res;
    }
}