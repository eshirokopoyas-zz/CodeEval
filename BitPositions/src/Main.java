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
            System.out.println(areBitsTheSame(Integer.valueOf(params[0]), Integer.valueOf(params[1]), Integer.valueOf(params[2])));
        }
    }
    private static boolean areBitsTheSame(int n, int p1,int p2)
    {

        return ((n>>>(p1-1)&1)==(n>>>(p2-1)&1));
    }

}
