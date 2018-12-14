import java.util.Scanner;
import java.util.*;
import java.io.*;

public class testing
{
    public static void main(String[] args) throws FileNotFoundException
    {
		ArrayList<Kid> Kids = new ArrayList<>();
		Scanner scanner = new Scanner(new File("kids.txt"));
        scanner.useDelimiter(",");
		int incriment = 1;
		String name = "null";
		boolean NorN = false;
		int age = 10;
		int i = 0;
		String string = "null";

		String[] tokens;
	    String line;

		while (scanner.hasNext())
		{
			line = scanner.next();
			tokens = line.split(", ");
			string = tokens[i];
		 	name = string;
			i ++;
		 	string = tokens[i];
		 	if(string.equals("nice"))
		 	{
		 		NorN = true;
		 	}
		 	else if (string.equals("naughty"))
		 	{
					NorN = false;
					scanner.next();
			}
			i ++;
			string = tokens[i];
			age = Integer.parseInt(string);
			Kid Kiddo = new Kid(name, NorN, age);
			Kids.add(Kiddo);
			i = 0;
		}
	}
}
