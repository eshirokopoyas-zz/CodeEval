import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by eshirokopoyas on 21.05.2015.
 */
public class Main
{
    public static ArrayList<Double> list;
    public static Comparator<Double> doubleComparator;
    public static NumberFormat formatter;
    public static void main(String[] args) throws IOException
    {
        formatter = new DecimalFormat("#0.000");
        doubleComparator = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2)
            {
                return o1.compareTo(o2);
            }
        };
        list = new ArrayList<Double>();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String[] params;
        while ((line = bufferedReader.readLine()) != null)
        {
            params=line.split(" ");
            System.out.println(sortNumbersWithinString(stringArrayToDoubleArray(params)));
            list.clear();
        }
    }
    private static StringBuilder sortNumbersWithinString(Double[] numbers)
    {
        StringBuilder res = new StringBuilder();
        list.addAll(Arrays.asList(numbers));
        Collections.sort(list,doubleComparator);
        for (Double item:list)
        {
            res.append(formatter.format(item.doubleValue()));
            res.append(" ");
        }

        return res.deleteCharAt(res.length()-1);
    }
    private static Double[] stringArrayToDoubleArray(String[] strings)
    {
        Double[] res = new Double[strings.length];
        for (int i=0;i<strings.length;i++)
        {
            res[i]=Double.valueOf(strings[i]);
        }
        return res;
    }
}