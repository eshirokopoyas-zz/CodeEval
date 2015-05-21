import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 18.05.2015.
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
            System.out.println(getFibonacciSeries(Integer.valueOf(line)));
        }
    }

    private static int getFibonacciSeries(int n)
    {
        switch (n)
        {
            case 0:return 0;
            case 1:return 1;
        }
        return getFibonacciSeries(n-1)+getFibonacciSeries(n-2);
    }
}