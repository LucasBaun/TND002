package lab2;
import java.io.*;
public class Lab2 {	

	public static void main(String[] args) throws IOException {
		
		InputStreamReader reader1 = new InputStreamReader(System.in);
		BufferedReader bread = new BufferedReader(reader1);
		
		Dictionary theDictionary = new Dictionary();
		
		File myFile;
		
		do {
			System.out.println("Type filename: ");
			String i = bread.readLine();
			myFile = new File(i);
			if (!myFile.canRead()) {
			System.err.println("Does not exist");
			}
		} while (!myFile.exists());			
		bread.close();
		
		bread = new BufferedReader(new FileReader(myFile));
		
		String input;		
		String inResult = "";
		
		while ((input = bread.readLine()) != null) {
			input = input.trim();
			input = input.toLowerCase();
			inResult += input + " ";			

		}
		bread.close();
		String arrayWords[] = inResult.split(" +");		
		for (int pass = 0; pass < arrayWords.length; ++pass) {
			try {
				double error = Double.parseDouble(arrayWords[pass]);
			} catch(NumberFormatException ierr) {				
				System.out.println(theDictionary.addString(arrayWords[pass]));
			}			
		}
		System.out.println(theDictionary + "\n");
		System.out.println(theDictionary.sortList(Word.BYCOUNTS) + theDictionary);
		System.out.println(theDictionary.sortList(Word.BYNAME) + theDictionary);
		System.out.println(theDictionary.sortList(Word.ORIGINAL) + theDictionary);
		
		BufferedWriter Wread = new BufferedWriter(new FileWriter("Newsource.txt"));
		Wread.write(theDictionary.toString());
		Wread.write(theDictionary.sortList(Word.BYCOUNTS).toString() + theDictionary.toString());
		
		Wread.close();
		
		
		
	}
}
