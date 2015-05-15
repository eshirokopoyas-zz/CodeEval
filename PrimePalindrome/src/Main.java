/**
 * Created by eshirokopoyas on 15.05.2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        for (int i=999;i>0;i-=2)
        {
            if (isPalindrome(i)&&isPrime(i))
            {
                System.out.println(i);
                System.exit(0);
            }
        }
    }

    public static boolean isPalindrome(int s)
    {
        String n=String.valueOf(s);
        return n.equals(new StringBuilder(n).reverse().toString());
    }
    public static boolean isPrime(int n)
    {
        boolean res=true;
        for (int i=3;i<Math.sqrt(n);i++)
        {
            res&=!(n%i==0);
        }
        return res;
    }
}
