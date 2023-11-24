package projectsForBeginners;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

	public static void main(String[] args) throws IOException {
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); //defines read as a bufferreader
		
		System.out.println("Enter a word: ");					//asks for input
		String word = read.readLine();							//uses the read to add the input to the String word
		System.out.println("Your original word is: " + word);	//Prints out the original word
		
		String word2 = ""; 							//Creates the word2 outside the for-loop so it "exists"
		for (int i = 0; i<word.length(); ++i) {		//for-loop that goes through all the chars in the word length
			
			char letter = word.charAt(i); 			//reads the char of the position form i
			word2 = letter + word2;					//adds the char to the start of word2
		}
		
		System.out.println("Your reversed word is: " + word2);	//prints out word2  

	}

}