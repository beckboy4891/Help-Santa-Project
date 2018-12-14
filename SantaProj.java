import java.util.Scanner;
import java.util.*;
import java.io.*;

public class test
{
    public static void main(String[] args) throws FileNotFoundException
    {
	String[] tokens;
	ArrayList<Kid> Kids = new ArrayList<>();
	String current = "null";
	String name = "null";
	int age = 0;
	boolean NorN = false;
        String line;
        String string;
        int increment = 0;
        ArrayList<String> info = new ArrayList<>();
        Scanner scanner = new Scanner(new File("kids.txt"));
        while (scanner.hasNext())
        {
            //tokenize the last line read from the file
            line = scanner.nextLine();
            tokens = line.split(", ");

            //handle the tokens
            for (String str: tokens){
                 System.out.println (str);
                 info.add(str);
			 }
        }
        scanner.close();
        for(int i = 0; i < info.size(); i ++){
			current = info.get(i);
			if(increment == 0){
				name = current;
				increment ++;
			}
			else if (increment == 1){
				if(current.equals("nice")){
					NorN = true;
					increment ++;
				}
				else if (current.equals("naughty")){
					NorN = false;
					increment ++;
				}
			}
			else if (increment == 2){
				age = Integer.parseInt(current);
				increment = 0;
			}
		}
		Kid Kiddo = new Kid(name, NorN, age);
		Kids.add(Kiddo);
	}
}
