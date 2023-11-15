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
			System.err.println("yes");
			
		} while (myFile.exists() == false);
		
		

	}

}
