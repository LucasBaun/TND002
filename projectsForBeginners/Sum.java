package projectsForBeginners;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Sum {

	public static void main(String[] args) throws IOException {
	
		
		 
        System.out.println("Enter a Number for X: "); 			//Prints out a text
        int x = input();										//Creates an int called X with the value from input()
        System.out.println("You enterded " + x + " as X.\n");	//prints out text + int X
        	
        System.out.println("Enter a Number for Y: ");			//prints out a text
        int y = input();										//creates an int called Y with the value from input()
        System.out.println("You enterded " + y + " as Y.\n");	//prints out text + int Y
        
        int z = x + y;											//creates an int called Z that has the value of X + Y
        System.out.println("X + Y = " + z);						//prints out text + int Z
	}
	
	private static int input() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	//Creates a bufferreader called reader that reads the inputs from person to an String
		int arg = Integer.parseInt(reader.readLine());		//creates an arg from the input and changes the String from the bufferreader to an integer
		return arg;			//returns the int from where it was called from
	}	
}
