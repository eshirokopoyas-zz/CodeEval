import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 18.05.2015.
 */
public class Main
{
    public static final String COMMA=",";
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(getUniqueElements(stringBuilder.append(line)));
            stringBuilder.setLength(0);
        }
    }
    private static StringBuilder getUniqueElements(StringBuilder stringBuilder)
    {
        int prevComma=stringBuilder.indexOf(COMMA);
        int nextComma;
        String prev=stringBuilder.substring(0,prevComma);
        String next;

        while ((nextComma=stringBuilder.indexOf(COMMA,prevComma+1))!=-1)
        {
            next=stringBuilder.substring(prevComma+1,nextComma);
            if (prev.equals(next))
            {
                stringBuilder.delete(prevComma,nextComma);
            }
            else
            {
                prev=next;
                prevComma=nextComma;
            }
        }
        next=stringBuilder.substring(prevComma+1);
        if (prev.equals(next))
        {
            stringBuilder.delete(prevComma,stringBuilder.length());
        }
        return stringBuilder;
    }
}