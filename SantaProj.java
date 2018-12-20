import java.util.Scanner;
import java.util.*;
import java.io.*;

public class SantaProj
{
    public static void main(String[] args) throws FileNotFoundException
    {
	String[] tokens;
	//Array lists used through the program//
	ArrayList<Kid> Kids = new ArrayList<>();
	ArrayList<String> info = new ArrayList<>();//Stores temporarily the information from the "kids.txt file"//
	   
	//Initial temporary variables declaration//
	String current = "null";
	String name = "null";
        String line;
        String string;
	    
	boolean NorN = false;
	    
	double money = 10000.00;
	double kidAmt = 0.0;
	    
	//set up temporary instances of Kid and Gift to be set in loops//
	Kid tempKid = new Kid();
	Gift tempGift = new Gift();

        int increment = 0;
        int amtDays = 10;
	int age = 0;
	   
        //Sets up kids.txt as the input file//
        Scanner scanner = new Scanner(new File("kids.txt"));
        Scanner reader = new Scanner(System.in);
	    
	//inputs information necessary for determining gifts//
        System.out.println("How many days do you have to build?");
        amtDays = reader.nextInt();
        System.out.println("How much money do you have to spend?");
        money = reader.nextDouble();
	    
	multiplier = 1 + 100/money;

	//Scans in information from kids.txt//
        while (scanner.hasNext())
        {
            //tokenize the last line read from the file
            line = scanner.nextLine();
	    //", " between each value//
            tokens = line.split(", ");

            //handle the tokens
            for (String str: tokens){
                 info.add(str);
			 }
        }
        scanner.close();
	//Adds information from "kids" to a temporary array "info"//
        for(int i = 0; i < info.size(); i ++){
			current = info.get(i);
			//goes through the "info" array and creates a Kid to add to the "kid" array//
		
			if(increment == 0){	//If the array index is a name (determined by the int increment) stores the value in the temporary name//
				name = current;
				increment ++;
			}
			
			//If the array index is a boolean "naughty or nice" (determined by the int increment) stores the value in the temporary variable "NorN"//
			else if (increment == 1){	
				if(current.equals("nice")){
					//Changes the string "naughty" or "nice" into a boolean true, or false//
					NorN = true;
					increment ++;
				}
				else if (current.equals("naughty")){
					NorN = false;
					increment ++;
				}
			}
		
		//If the array index is a int (age of the child determined by the int increment) stores the value in the temporary variable age//
			else if (increment == 2){
				age = Integer.parseInt(current);
				increment = 0;
				//Creates a new temporary kid to add to the "kids" array list//
				Kid Kiddo = new Kid(name, NorN, age);
				Kids.add(Kiddo);
			}
		}
		for(int x = 0; x < Kids.size(); x ++){
			Kid child = Kids.get(x);
		}
	    
	   	 /*Gift section*/
		Scanner scan = new Scanner(new File("gifts.txt"));
		ArrayList<Gift> gift = new ArrayList<>();
	    	//Reads in file and assigns each line to the correct variable type//
		while (scan.hasNext())
		{
			//set values for all aspects of the gift - name, ages, price, and days to build//
			String giftName = scan.nextLine();
			int minAge = Integer.parseInt(scan.nextLine());
			int maxAge = Integer.parseInt(scan.nextLine());
			double price = Double.parseDouble(scan.nextLine());
			int days = Integer.parseInt(scan.nextLine());
			
			//gift is only added to array if it takes less than or equal to the amt. days available to build//
			if(days <= amtDays)
			{
				gift.add(new Gift(giftName,minAge,maxAge,days,price));
			}
		}
	
	    for(Kid k : Kids)//naughty kids count as a "half" kid, receiving half as much money as nice kids//
		{
			if(k.isNice())
				kidAmt++;
			else
				kidAmt += .5;
		}

		double moneyPerKid = money / kidAmt;
		//this measures the range kid prices can fall within - for smaller base amounts, there is a larger range//
	    	moneyPerKid *= multiplier;

		//set the max amount each kid can receive based on the range above//
	    	for(int x = 0; x < Kids.size(); x++)
		{
			(Kids.get(x)).setCostMax(moneyPerKid);
		}

		//as long as it is possible to give a kid a gift, continues giving gifts//
	    	while(hasGift(gift, Kids, money))
		{
			for(int y = 0; y < Kids.size(); y++)
			{
				//chooseGift returns a double for amount the gift costs and updates Kids//
				money -= chooseGift(gift, Kids.get(y), money);
			}
		}

		//iterate through Kids, print information on them and their gifts//
	    	for(Kid k : Kids)
		{
			k.printInfo();

			for(Gift g : k.getGifts())
			{
				g.printInfo();
			}
		}

	    //print the amount of money remaining after gifts are assigned//	
	    System.out.println("\n" + money + " dollars remaining.");
	}
	
	//check whether it is possible to assign a gift//
	public static boolean hasGift(ArrayList<Gift> gifts, ArrayList<Kid> kids, double moneyLeft)
	{
		for(Gift g : gifts)
		{
			for(Kid k : kids)
			{
				if(giftMatches(k, g, moneyLeft))
				{
					return true;
				}
			}
		}

		return false;
	}
	
	public static double chooseGift(ArrayList<Gift> gifts, Kid kid, double moneyLeft)
	{
		boolean matches = false;
		double giftCost = 0.0;
		double moneyPerKid = kid.getCostMax();
		ArrayList<Gift> potentialGifts = new ArrayList<>();
		ArrayList<Gift> giftsKidGets = kid.getGifts();
		Gift giftChosen;

		for(Gift g : gifts)
		{
			if(giftMatches(kid, g, moneyLeft))
			{
				potentialGifts.add(g);
			}
		}

		int size = potentialGifts.size();
		int digit = (int) (Math.random() * size);

		if(size > 0)
		{
			kid.addGift(potentialGifts.get(digit));

			return potentialGifts.get(digit).getPrice();
		}

		return 0.0;
	}
	
	public static boolean giftMatches(Kid k, Gift g, double m)	//check if the gift and the kid are age compatible//
	{
		int kidAge = k.getAge();
		int giftMin = g.getMin();
		int giftMax = g.getMax();
		ArrayList<Gift> giftsKidGets = k.getGifts();
		boolean matches = true;
		double giftCost = g.getPrice();
		double moneyPerKid = k.getCostMax();

		giftCost = g.getPrice();

		if(giftCost > m)
			matches = false;

		for(Gift gi : giftsKidGets)
		{
			if(g.equals(gi))
				matches = false;
		}

		if(!((k.getCost() + giftCost) <= moneyPerKid))
		{
			matches = false;
		}

		if(kidAge < giftMin || kidAge > giftMax)	//kid age must be within age range of gift//
			matches = false;


		return matches;
	}
}
