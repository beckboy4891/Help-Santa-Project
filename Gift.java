//class by Emily Bixler//

//initialize class, representing each potential gift
public class Gift
{
	//set all to default values//
	String name = "";
	int minAge = 0, maxAge = 0;
	int timeToMake = 0;
	double price = 0.0;

	public Gift()	//blank instantiation//
	{
		name = "";
	}

	public Gift(String s, int mi, int ma, int t, double p)//initialize instance of "Kid", set all variables//
	{
		name = s;
		minAge = mi;
		maxAge = ma;
		timeToMake = t;
		price = p;
	}

	public int getMin()//return the minimum age for the gift//
	{
		return minAge;
	}

	public int getMax()//return the maximum age for the gift//
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

	public void printInfo()//print the stats of the gift//
	{
		System.out.println(name + "\n" + minAge + "\n" + maxAge + "\n" + timeToMake + "\n" + price);
	}
}
