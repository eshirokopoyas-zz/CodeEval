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
//        File file = new File(args[0]);
        File file = new File("c:\\1\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            formRomanNumber(line);
        }
    }
    private static void formRomanNumber(String number)
    {

    }
}