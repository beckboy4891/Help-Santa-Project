import java.util.*;
import java.io.*;
public class gift
{
	public static void main (String[]args) throws FileNotFoundException
	{
		//Reads in file - made by Andrew
		File file = new File ("gifts.txt");
		Scanner sc = new Scanner (file);
		while (sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
	}
}