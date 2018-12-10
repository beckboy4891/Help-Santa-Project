import java.util.*;

public class gift
{
	File file = new File ("gifts.txt");
	sc = new Scanner(new File("gifts"));
	while (sc.hasNextLine()) //Not Finished
	{
	}

	String toyName;
	int ageMin = 0;
	int ageMax = 0;
	double cost = 0;
	int daysTaken = 0;

	public void gift (int aI,int aM, double c, int dT)
	{
		ageMin = aI;
		ageMax = aM;
		cost = c;
		daysTaken = dT;
	}


}

