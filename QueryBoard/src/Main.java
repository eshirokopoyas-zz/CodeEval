import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 20.05.2015.
 */
public class Main
{
    public static final int DIMENSION=256;
    public static int[] board;
    public static void main(String[] args) throws IOException
    {

        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        int dim=DIMENSION*DIMENSION;
        board = new int[dim];
        for (int i=0;i<dim;i++)
        {
            board[i]=0;
        }
        String[] params;

        while ((line = bufferedReader.readLine()) != null)
        {
            params=line.split(" ");
            switch (params[0])
            {
                case "SetCol":setCol(Integer.valueOf(params[1]),Integer.valueOf(params[2]));break;
                case "SetRow":setRow(Integer.valueOf(params[1]), Integer.valueOf(params[2]));break;
                case "QueryCol":queryCol(Integer.valueOf(params[1]));break;
                case "QueryRow":queryRow(Integer.valueOf(params[1]));break;
            }
        }
    }
    private static void setRow(int i,int x)
    {
        for (int j=0;j<DIMENSION;j++)
        {
            board[i*DIMENSION+j]=x;
        }
    }
    private static void setCol(int j,int x)
    {
        for (int i=0;i<DIMENSION;i++)
        {
            board[i*DIMENSION+j]=x;
        }
    }
    private static void queryRow(int i)
    {
        int res=0;
        for (int j=0;j<DIMENSION;j++)
        {
            res+=board[i*DIMENSION+j];
        }
        System.out.println(res);
    }
    private static void queryCol(int j)
    {
        int res=0;
        for (int i=0;i<DIMENSION;i++)
        {
            res+=board[i*DIMENSION+j];
        }
        System.out.println(res);
    }
}