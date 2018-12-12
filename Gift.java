//initialize class, representing each potential gift
public class Gift
{
	String name = "";
	int minAge = 0, maxAge = 0;
	int timeToMake = 0;
	double price = 0.0;

	public Gift(String s, int mi, int ma, int t, double p)//initialize instance of "Kid", set all variables//
	{
		name = s;
		minAge = mi;
		maxAge = ma;
		timeToMake = t;
		price = p;
	}

	public int getMinAge()//return the minimum age for the gift//
	{
		return minAge;
	}

	public int getMaxAge()//return the maximum age for the gift//
	{
		return maxAge;
	}

	public int getTime()//return how long it takes to make the gift//
	{
		return timeToMake;
	}

	public String getName()//return kid's name//
	{
		return name;
	}

	public double getPrice()//return price of gift//
	{
		return price;
	}
}
