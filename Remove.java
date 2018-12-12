//By Emily Bixler//
public class Remove
{
	public boolean removeKid(Kid k, int age)	//remove kid from consideration based on age, naughty
	{
		if(k.getAge >= age)
			return true;	//kid should not receive gift

		if(!k.isNice)
			return true;	//kid should not receive gift

		return false;	//kid should receive gift
	}

	public boolean removeGift(Gift g, double p, int days) //remove gift that doesn't work in age range or price range//
	{
		if(g.getPrice > p)	//cannot use gift if above price range//
			return true;	//gift should be removed

		if(g.getDays > days)	//cannot make gift if takes too many days to build//
			return true;	//gift should be removed

		return false;	//gift should remain
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
