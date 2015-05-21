import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 21.05.2015.
 */
public class Main
{
    public static String[] coordinates;
    public static void main(String[] args) throws IOException
    {
        coordinates=new String[4];
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            line=line.replaceAll("[^-?0-9]+"," ");
            coordinates=line.trim().split(" ");
            System.out.println((int)Math.sqrt((Integer.valueOf(coordinates[0])-Integer.valueOf(coordinates[2]))*(Integer.valueOf(coordinates[0])-Integer.valueOf(coordinates[2]))+(Integer.valueOf(coordinates[1])-Integer.valueOf(coordinates[3]))*(Integer.valueOf(coordinates[1])-Integer.valueOf(coordinates[3]))));
        }
    }
}