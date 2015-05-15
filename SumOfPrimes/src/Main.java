/**
 * Created by eshirokopoyas on 15.05.2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        long sum = 5;
        long number=3;
        int counter=2;
        while(counter<1000)
        {
            number+=2;
            if (isPrime(number))
            {
                sum+=number;
                counter++;
            }
        }
        System.out.println(sum);
    }
    public static boolean isPrime(long n)
    {
        boolean res=true;
        for (int i=3;i<=Math.sqrt(n);i++)
        {
            res&=!(n%i==0);
        }
        return res;
    }
}
