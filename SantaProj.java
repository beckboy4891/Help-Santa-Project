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
		String string = "null";

		String[] tokens;
	    String line;

		while (scanner.hasNext())
		{
			line = scanner.next();
			tokens = line.split(", ");
			 for (int i = 0; i < tokens.length; i ++)
			 {
				string = tokens[i];
		 		name = string;
		 		string = tokens[(i + 1)];
		 		if(string.equals("nice"))
		 		{
		 			NorN = true;
		 		}
		 		else if (string.equals("naughty"))
		 		{
						NorN = false;
						scanner.next();
				}
				string = tokens[(i + 1)];
				age = Integer.parseInt(string);
				Kid Kiddo = new Kid(name, NorN, age);
				Kids.add(Kiddo);
			}
		}
	}
}
