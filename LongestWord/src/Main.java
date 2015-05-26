import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 26.05.2015.
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
            params=line.split(" ");
            System.out.println(getLongestWord(params));
        }
    }
    private static String getLongestWord(String[] words)
    {
        if (words.length==1) return words[0];
        String res=words[0];
        int resLength=words[0].length();
        for (int i=1;i<words.length;i++)
        {
            if (words[i].length()>resLength)
            {
                res=words[i];
                resLength=words[i].length();
            }
        }

        return res;
    }
}