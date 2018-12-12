import java.util.*;
import java.io.*;
public class gift
{
	public static void main (String[]args) throws FileNotFoundException
	{
		//Reads in file - made by Andrew
		File file = new File ("gifts.txt");
		Scanner sc = new Scanner (file);

		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> ageMin = new ArrayList<Integer>();
		ArrayList<Integer> ageMax = new ArrayList<Integer>();
		ArrayList<Double> price = new ArrayList<Double>();
		ArrayList<Integer> days = new ArrayList<Integer>();
		String nameP;
		int ageMi;
		int ageMa;
		double pri;
		int da;


		while (sc.hasNextLine())
		{

			nameP = sc.nextLine();
			name.add(nameP);
			ageMi = sc.nextInt();
			ageMin.add(ageMi);
			ageMa = sc.nextInt();
			ageMax.add(ageMa);
			pri = sc.nextDouble();
			price.add(pri);
			da = sc.nextInt();
			days.add(da);


		}
		for(String d : name)
		System.out.println(d);
	}
}
