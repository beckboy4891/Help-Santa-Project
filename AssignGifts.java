import java.util.*;
import java.io.*;
import java.lang.*;


public class AssignGifts
{
	public static void main(String[] args)
	{
		ArrayList<Kid> kids = new ArrayList<>();
		double money = 1000.00;
		double kidAmt = 0.0;
		Kid tempKid = new Kid();
		Gift tempGift = new Gift();
		
		double multiplier = 1.0 + 50 / money;
		
		//sets amount for kids depending on if naughty or nice
		for(Kid k : kids)
		{
			if(k.isNice())
				kidAmt++;
			else
				kidAmt += .5;
		}
		//divides money equally per kid 
		double moneyPerKid = money / kidAmt;
		moneyPerKid *= 1.1;
		//sets the max amount availble 
		for(int x = 0; x < kids.size(); x++)
		{
			(kids.get(x)).setCostMax(moneyPerKid);
		}

		//take in kids
		
		//4.99 = cheapest present
		while(hasGift(gift, Kids, money))
		{
			for(int y = 0; y < Kids.size() && hasGift(gift, Kids, money), y++)
			{
				money -= chooseGift(gift, Kids.get(y), money);

				tempKid = Kids.get(y);
			}
		}
	}
	
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

	public Kid chooseGift(ArrayList<Gift> gifts, Kid kid, double moneyLeft)
	{
		boolean matches = false;
		double giftCost = 0.0;
		double moneyPerKid = kid.getCostMax();
		ArrayList<Gift> potentialGifts = new ArrayList<Gift>();
		ArrayList<Gift> giftsKidGets = kid.getGifts();
		Gift giftChosen;
		
		//adds gift to childs list and removes money from their set amount that they have
		for(Gift g : gifts)
		{
			if(giftMatches(kid, g, moneyLeft))
			{
				potentialGifts.add(g);
			}
		}

		int size = potentialGifts.size();
		int digit = (int) (Math.random() * size);
		//checks if they can get the present
		if(size > 0)
		{
			kid.addGift(potentialGifts.get(digit));
		}

		return kid;
	}

	public boolean giftMatches(Kid k, Gift g)	//check if the gift and the kid are age compatible//
	{
		int kidAge = k.getAge();
		int giftMin = g.getMin();
		int giftMax = g.getMax();

		if(kidAge >= giftMin && kidAge <= giftMax)	//kid age must be within age range of gift//
			return true;	//gift matches//


		return false;	//gift does not match//
	}
}
