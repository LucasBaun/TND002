package projectsForBeginners;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessingGame {

	public static void main(String[] args) throws IOException {
        int highest_num = 0;
        int nmbr_guesses = 1;
        int random_num = 0;
        int guess = 0;
        
		
		System.out.println("Whats the highest number? ");
        highest_num = input();	
        
        random_num = (int)Math.floor(Math.random() * (highest_num + 1));
        System.out.println("Ok, guess the generated number: ");
        guess = input();
        
        
        while (guess != random_num) {
        	if (guess < random_num) {
        		System.out.println("Number is higher then " + guess + ", guess again: ");
        		guess = input();
        		++nmbr_guesses;
        	} else {
        		System.out.println("Number is lower then " + guess + ", guess again: ");
        		guess = input();
        		++nmbr_guesses;
        	}
        }
        
        
        System.out.println("Congrats! you guessed " + random_num + " and it only took " +  nmbr_guesses + " guesses.");
		

	}
	
	public static int input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	//Creates a bufferreader called reader that reads the inputs from person to an String
		int arg = Integer.parseInt(reader.readLine());		//creates an arg from the input and changes the String from the bufferreader to an integer
		return arg;			//returns the int from where it was called from
	}

}
