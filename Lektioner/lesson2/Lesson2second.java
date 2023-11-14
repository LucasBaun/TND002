package lesson2;
import java.io.*;

public class Lesson2second {

	public static void main(String[] args) throws IOException {
		
		String completeText = "Hell2o world";
		File myFile = new File("Result.txt");
		
		FileWriter step1 = new FileWriter(myFile);
		BufferedWriter step2 = new BufferedWriter(step1);
		step2.write(completeText);
		step2.close();
	}

}
