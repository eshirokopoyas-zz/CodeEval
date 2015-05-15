import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 15.05.2015.
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
            line = line.trim();
            if (!line.isEmpty())
            {
                System.out.println(reverseWords(line));
            }
        }
    }
    private static String reverseWords(String line)
    {
        StringBuilder res = new StringBuilder();
        String[] words = line.split(" ");
        for (int i = words.length-1;i>=0;i--)
        {
            res.append(words[i]);
            res.append(' ');
        }

        return res.toString().trim();
    }
}
