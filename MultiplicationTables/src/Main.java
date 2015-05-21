/**
 * Created by eshirokopoyas on 18.05.2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        for (int i=0;i<12;i++)
        {
            for (int j=0;j<12;j++)
            {
                int res=(i + 1) * (j + 1);
                if (j!=0)
                {
                    for (int k=0;k<4-String.valueOf(res).length();k++)
                    {
                        System.out.print(' ');
                    }
                }
                System.out.print(res);
            }
            System.out.println();
        }
    }
}
