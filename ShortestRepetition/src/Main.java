import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 25.05.2015.
 */
public class Main
{
    public static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException
    {
        stringBuilder=new StringBuilder();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(getShortestRepetition(stringBuilder.append(line)));
            stringBuilder.setLength(0);
        }
    }
    private static int getShortestRepetition(StringBuilder line)
    {
        int length = line.length();
        int res=length;
        for (int i=1;i<=length/2;i++)
        {
            if (length%i==0)
            {
                for (int j=0;j<length/i;j++)
                {
                    if (!line.substring(0,i).equals(line.substring(i*j, i*(j+1))))
                    {
                        break;
                    }
                    else
                    {
                        if (j==length/i-1)
                        {
                            return i;
                        }
                    }
                }
            }
            else continue;
        }
        return res;
    }
}