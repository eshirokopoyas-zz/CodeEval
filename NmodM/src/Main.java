import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 20.05.2015.
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
            params=line.split(",");
            System.out.println(mod(Integer.valueOf(params[0]),Integer.valueOf(params[1])));
        }
    }
    private static int mod(int n,int m)
    {
        int res=n;
        while(res>m) res-=m;
        return res;
    }
}