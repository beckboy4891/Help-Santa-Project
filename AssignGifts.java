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

		for(Kid k : kids)
		{
			if(k.isNice())
				kidAmt++;
			else
				kidAmt += .5;
		}

		double moneyPerKid = money / kidAmt;
		moneyPerKid *= 1.1;

		for(int x = 0; x < kids.size(); x++)
		{
			(kids.get(x)).setCostMax(moneyPerKid);
		}

		//take in kids

		while(money >= 4.99)
		{
			for(int y = 0; y < kids.size() && money >= 4.99; y++)
			{
				(kids.get(y)).chooseGift(gifts, kids.get(y), money);


			}
		}
	}

	public Kid chooseGift(ArrayList<Gift> gifts, Kid kid, double moneyLeft)
	{
		boolean matches = false;
		double giftCost = 0.0;
		double MoneyPerKid = kid.getCostMax();
		ArrayList<Gift> potentialGifts = new ArrayList<Gift>();
		ArrayList<Gift> giftsKidGets = kid.getGifts();
		Gift giftChosen;

		for(Gift g : gifts)
		{
			giftCost = g.getPrice();

			matches = giftMatches(kid, g);

			if(gi > moneyLeft)
				matches = false;

			for(Gift gi : giftsKidGets)
			{
				if(g.equals(gi))
					matches = false;
			}

			if(matches = true && (kid.getCost() + giftCost) < moneyPerKid)
			{
				potentialGifts.add(g);
			}
		}

		int size = potentialGifts.size();
		int digit = Math.random() * size;

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