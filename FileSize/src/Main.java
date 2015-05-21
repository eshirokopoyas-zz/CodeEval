import java.io.File;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 18.05.2015.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println(new File(args[0]).length());
    }
}