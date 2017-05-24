import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eshirokopoyas on 20.05.2015.
 */
public class Main
{
public static void main(String[] args) throws IOException
{
	File file = new File(args[0]);
//	File file = new File("C:\\1\\1.txt");
	BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	String line;
	
	while ((line = bufferedReader.readLine()) != null)
	{
		System.out.println(processLine(line));
	}
}
	private static String processLine(String line)
	{
		String[] params = line.split("\\|");
		String[] cards = params[0].trim().split(" ");
		char trump = params[1].trim().toCharArray()[0];
		
		Card card1 = new Card(cards[0].toCharArray());
		Card card2 = new Card(cards[1].toCharArray());
		
		if (card1.suit==trump&&card2.suit!=trump)
			return cards[0];
		if (card2.suit==trump&&card1.suit!=trump)
			return cards[1];
		
		if (card1.compareTo(card2)==1)
			return cards[0];
		
		if (card1.compareTo(card2)==-1)
			return cards[1];
//trim?
		return params[0];
	}
	
	static class Card implements Comparable<Card>
	{
		int number;
		char suit;
		
		public Card(char[] cardChars)
		{
			switch (cardChars[0])
			{
				case '1':
				{
					if (cardChars.length==2)
					{
						number=1;
						suit=cardChars[1];
					}
					else
					{
						number=10;
						suit=cardChars[2];
					}
					break;
				}
				case '2':
				{
					number=2;
					suit=cardChars[1];
					break;
				}
				case '3':
				{
					number=3;
					suit=cardChars[1];
					break;
				}
				case '4':
				{
					number=4;
					suit=cardChars[1];
					break;
				}
				case '5':
				{
					number=5;
					suit=cardChars[1];
					break;
				}
				case '6':
				{
					number=6;
					suit=cardChars[1];
					break;
				}
				case '7':
				{
					number=7;
					suit=cardChars[1];
					break;
				}
				case '8':
				{
					number=8;
					suit=cardChars[1];
					break;
				}
				case '9':
				{
					number=9;
					suit=cardChars[1];
					break;
				}
				case 'J':
				{
					number=11;
					suit=cardChars[1];
					break;
				}
				case 'Q':
				{
					number=12;
					suit=cardChars[1];
					break;
				}
				case 'K':
				{
					number=13;
					suit=cardChars[1];
					break;
				}
				case 'A':
				{
					number=14;
					suit=cardChars[1];
					break;
				}
			}
		}
		
		@Override
		public int compareTo(Card o)
		{
			return Integer.compare(this.number,o.number);
		}
	}
}