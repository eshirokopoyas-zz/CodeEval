import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by eshirokopoyas on 22.05.2015.
 */
public class Main
{
    public static Comparator<Map.Entry<Character, Integer>> entryComparator;
    public static TreeMap<Character,Integer> countList;
    public static List<Map.Entry<Character,Integer>> entryList;
    public static void main(String[] args) throws IOException
    {
        entryList = new ArrayList<Map.Entry<Character,Integer>>();
        countList = new TreeMap<Character, Integer>();
        entryComparator=new Comparator<Map.Entry<Character, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String[] params;
        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println(getLowestUniqueNumberPlace(line));
            countList.clear();
            entryList.clear();
        }
    }
    private static int getLowestUniqueNumberPlace(String line)
    {
        int res=0;
        char[] chars = line.toCharArray();
        for (int i=0;i<chars.length;i++)
        {
            countList.put(chars[i],countList.containsKey(chars[i])?countList.get(chars[i]).intValue()+1:1);
        }
        entryList.addAll(countList.entrySet());
        Collections.sort(entryList, entryComparator);

        return entryList.get(0).getValue()>1?0:(line.indexOf(entryList.get(0).getKey())+1)/2+1;
    }
}
