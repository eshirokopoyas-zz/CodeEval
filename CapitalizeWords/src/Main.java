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
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        stringBuilder=new StringBuilder();
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(capitalizeWords(stringBuilder.append(line)));
            stringBuilder.setLength(0);
        }
    }
    private static StringBuilder capitalizeWords(StringBuilder line)
    {
        line.replace(0,1,line.substring(0,1).toUpperCase());
        int index=0;
        while ((index=line.indexOf(" ",index))!=-1)
        {
            line.replace(++index, index+1, line.substring(index,index+1).toUpperCase());
        }
        return line;
    }
}