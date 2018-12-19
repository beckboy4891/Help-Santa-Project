import java.util.Scanner;
import java.util.*;
import java.io.*;

public class SantaProj
{
    public static void main(String[] args) throws FileNotFoundException
    {
		String[] tokens;
		ArrayList<Kid> Kids = new ArrayList<>();
		String current = "null";
		String name = "null";
		int age = 0;
		boolean NorN = false;
		double money = 10000.00;
		double kidAmt = 0.0;
		Kid tempKid = new Kid();
		Gift tempGift = new Gift();
        String line;
        String string;
        int increment = 0;
        int amtDays = 10;
        ArrayList<String> info = new ArrayList<>();
        Scanner scanner = new Scanner(new File("kids.txt"));
        Scanner reader = new Scanner(System.in);
        System.out.println("How many days do you have to build?");
        amtDays = reader.nextInt();
        System.out.println("How much money do you have to spend?");
        money = reader.nextDouble();


        while (scanner.hasNext())
        {
            //tokenize the last line read from the file
            line = scanner.nextLine();
            tokens = line.split(", ");

            //handle the tokens
            for (String str: tokens){
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

		while (scan.hasNext())
		{
			String giftName = scan.nextLine();
			int minAge = Integer.parseInt(scan.nextLine());
			int maxAge = Integer.parseInt(scan.nextLine());
			double price = Double.parseDouble(scan.nextLine());
			int days = Integer.parseInt(scan.nextLine());

			if(days <= amtDays)
			{
				gift.add(new Gift(giftName,minAge,maxAge,days,price));
			}
		}


		for(Kid k : Kids)
		{
			if(k.isNice())
				kidAmt++;
			else
				kidAmt += .5;
		}

		double moneyPerKid = money / kidAmt;
		moneyPerKid *= 1.2;

		for(int x = 0; x < Kids.size(); x++)
		{
			(Kids.get(x)).setCostMax(moneyPerKid);
		}

		//take in kids

		while(money >= 4.99)
		{
			for(int y = 0; y < Kids.size() && money >= 4.99; y++)
			{
				money -= chooseGift(gift, Kids.get(y), money);

				tempKid = Kids.get(y);
			}
		}

		for(Kid k : Kids)
		{
			k.printInfo();

			for(Gift g : k.getGifts())
			{
				g.printInfo();
			}
		}

		System.out.println("\n" + money + " dollars remaining.");
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
			giftCost = g.getPrice();

			matches = giftMatches(kid, g);

			if(giftCost > moneyLeft)
				matches = false;

			for(Gift gi : giftsKidGets)
			{
				if(g.equals(gi))
					matches = false;
			}

			if(matches && ((kid.getCost() + giftCost) <= moneyPerKid))
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
	public static boolean giftMatches(Kid k, Gift g)	//check if the gift and the kid are age compatible//
	{
		int kidAge = k.getAge();
		int giftMin = g.getMin();
		int giftMax = g.getMax();

		if(kidAge >= giftMin && kidAge <= giftMax)	//kid age must be within age range of gift//
			return true;	//gift matches//


		return false;	//gift does not match//
	}
}
