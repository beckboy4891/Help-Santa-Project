//Made by Emily Bixler//
import java.util.*;
import java.io.*;

public class Kid
{
	//initialize variables//
	String name;
	boolean nice;
	int age;
	double costSoFar = 0.0, costMax;
	ArrayList<Gift> gifts = new ArrayList<>();

	public Kid()	//blank instantiation//
	{
		name = "";
		nice = true;
		age = 1;
	}

	public Kid(String s, boolean n, int a)	//initialize instance of "Kid", set all variables//
	{
		name = s;
		nice = n;
		age = a;
	}
	public boolean isNice()		//return true for nice, false for naughty//
	{						
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
	public void addCost(double d)	//increases the total cost attributed to the kid thus far//
	{
		costSoFar += d;
	}
	public double getCost()	//return cost spent on the kid so far//
	{
		return costSoFar;
	}
	public void printInfo()	//print info about the kid//
	{
		System.out.println("Kid name: " + name);
		if(nice)
			System.out.println("Nice");
		else
			System.out.println("Naughty");
		System.out.println("Age: " + age);
		System.out.print("Cost for this child : $");
		System.out.printf("%.2f",costSoFar);
		System.out.print ("\n");
	}
	public ArrayList<Gift> getGifts()	//return an array of gifts kid has received//
	{
		return gifts;
	}
	public void addGift(Gift g)	//adds a gift to the list of gifts the kid has received, increase cost spent on them//
	{
		gifts.add(g);

		addCost(g.getPrice());
	}
	public void setCostMax(double c)	//set max amount to be spent on a kid, nice kids get twice as much as naughty do//
	{
		if(nice)
			costMax = c;

		else
			costMax = c / 2;

		costMax *= 1.1;
	}
	public double getCostMax()	//return max amount to be spent on the kid
	{
		return costMax;
	}
}
