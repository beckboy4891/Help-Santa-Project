//Made by Emily Bixler//
public class Kid
{
	String name;
	boolean nice;
	int age;

	public Kid(String s, boolean n, int a)	//initialize instance of "Kid", set all variables//
	{
		name = s;
		nice = n;
		age = a;
	}
	public boolean isNice()
	{						//return true for nice, false for naughty//
		return nice;
	}
	public int getAge()	//return kid's age//
	{
		return age;
	}
	public String getName()	//return kid's name//
	{
		return name;
	}
	
	public void printInfo()
	{
		System.out.println("Kid name: " + name);
		if(nice)
			System.out.println("Nice");
		else
			System.out.println("Naughty");
		System.out.println("Age: " + age);
	}
}
