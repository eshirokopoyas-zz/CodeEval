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
        String[] params;
        while ((line = bufferedReader.readLine()) != null)
        {
            line = line.trim();
            params = line.split(",");
            System.out.println(getMinMultiple(Integer.valueOf(params[0]),Integer.valueOf(params[1])));
        }
    }
    private static int getMinMultiple(int x, int n)
    {
        int res=n;
        int multiplier = 2;

        while (res<x)
        {
            res=n*multiplier;
            multiplier++;
        }
        return res;
    }

}
