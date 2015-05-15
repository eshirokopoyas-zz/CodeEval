import java.io.*;

/**
 * Created by eshirokopoyas on 14.05.2015.
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
            params = line.split(" ");
            System.out.println(generateOutputLine(Integer.valueOf(params[0]),Integer.valueOf(params[1]),Integer.valueOf(params[2])));
        }
    }
    private static String generateOutputLine(int firstDivider, int secondDivider, int count)
    {
        StringBuilder res = new StringBuilder();
        boolean dividedByFirst=false;
        boolean dividedBySecond=false;
        for (int i=1;i<=count;i++)
        {
            dividedByFirst=false;
            dividedBySecond=false;
            if (i % firstDivider == 0)
            {
                res.append('F');
                dividedByFirst=true;
            }
            if (i % secondDivider == 0)
            {
                res.append('B');
                dividedBySecond=true;
            }
            if (!(dividedByFirst||dividedBySecond))
            {
                res.append(i);
            }
            res.append(' ');
        }

        return res.toString().trim();
    }
}
