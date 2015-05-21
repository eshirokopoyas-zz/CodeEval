import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
            System.out.println(getMaximumBeauty(prepareLine(line)));
        }
    }
    private static int getMaximumBeauty(String line)
    {
        line=prepareLine(line);
        int res=0;
        Comparator<Map.Entry<Character, Integer>> entryComparator = new Comparator<Map.Entry<Character, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        };
        char[] chars = line.toCharArray();
        TreeMap<Character,Integer> beautyList = new TreeMap<Character, Integer>();
        for (int i=0;i<chars.length;i++)
        {
            beautyList.put(chars[i],beautyList.containsKey(chars[i])?beautyList.get(chars[i]).intValue()+1:1);
        }
        List<Map.Entry<Character,Integer>> entryList = new ArrayList<Map.Entry<Character,Integer>>(beautyList.entrySet());
        Collections.sort(entryList, entryComparator);
        int prev;
        int initial=26;
        for (Map.Entry<Character,Integer> item:entryList)
        {
            prev=item.getValue().intValue();
            res+=initial*prev;
            initial--;
        }
        return res;
    }
    private static String prepareLine(String input)
    {
        return input.replaceAll("[^A-Za-z]","").toLowerCase();
    }
}