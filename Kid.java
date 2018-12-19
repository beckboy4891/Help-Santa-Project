//Made by Emily Bixler//
import java.util.*;
import java.io.*;

public class Kid
{
	String name;
	boolean nice;
	int age;
	double costSoFar = 0.0, costMax;
	ArrayList<Gift> gifts = new ArrayList<>();

	public Kid()
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
	public void addCost(double d)
	{
		costSoFar += d;
	}
	public double getCost()
	{
		return costSoFar;
	}
	public void printInfo()
	{
		System.out.println("Kid name: " + name);
		if(nice)
			System.out.println("Nice");
		else
			System.out.println("Naughty");
		System.out.println("Age: " + age);
		System.out.println("Cost so far: " + costSoFar);
	}
	public ArrayList<Gift> getGifts()
	{
		return gifts;
	}
	public void addGift(Gift g)
	{
		gifts.add(g);

		addCost(g.getPrice());
	}
	public void setCostMax(double c)
	{
		if(nice)
			costMax = c;

		else
			costMax = c / 2;

		costMax *= 1.1;
	}
	public double getCostMax()
	{
		return costMax;
	}
}
