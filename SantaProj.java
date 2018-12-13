import java.util.Scanner;
import java.util.*;
import java.io.*;

public class SantaProj
{
    public static void main(String[] args) throws FileNotFoundException
    {
		int incriment = 1; //keeps track of what is being inputted from the file (name, age, naughty or nice)//
		String name = "null";
		boolean NorN = false; //temporary variables for storing the current childs information//
		int age = 0;

		ArrayList<Kid> Kids = new ArrayList<>();  //Array list that holds all of the "kid" Variables//
        Scanner scanner = new Scanner(new File("kids.txt"));
        scanner.useDelimiter(",");

        while (scanner.hasNext())
        {
         	if(incriment ==  1){   //inputs name of the current child and adds one to the counter//
			name = scanner.next();
			incriment ++;
		}
		if(incriment == 2){
			if(scanner.next().equals(" nice")){ //determines wether "nice" is true or false and adds one to the counter//
				NorN = true;
				incriment ++;
			}
			else{
				NorN = false;
				incriment ++;
			}
		}
		else{				//gets the age of the child and converts it from a string to a integer, resets the counter//
			age = Integer.parseInt(scanner.next());
			incriment = 0;
		}
		Kid Kiddo = new Kid(name, NorN, age);	//creates a new child with the provided information//
		Kids.add(Kiddo);						//Adds the new "kid" to the list//
        }
        scanner.close();
		for(int i = 0; i < Kids.size(); i ++){ //Loops through and prints out each child's information//
			Kids.get(i).printInfo();
		}
	    
	    		/*Gift section"*/
		int increment = 0;//keeps track of gift scanner
		int ageMN = 0;
		int ageMX = 0;
		double pri = 0.0;
		int build = 0;
		String user = "null";
		String gift ="null";
		while (giftScanner.hasNext())
		{
			if(increment == 0)
				{
				gift = giftScanner.nextLine();
				increment++;
				}
			if(increment == 1)
			{
				user = giftScanner.nextLine();
				
				increment++;

			}
			if(increment == 2)
			{
				gift = giftScanner.nextLine();
				increment++;

			}
			if(increment == 3)
			{
				gift = giftScanner.nextLine();
				increment++;

			}
			if(increment == 4)
			{
				gift = giftScanner.nextLine();
				increment++;

			}
			else{
				increment = 0;
			}
		}
}

	}
}
    }
}
