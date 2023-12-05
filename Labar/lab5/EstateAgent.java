package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EstateAgent {
	public final int ALLBUILDINGS = 1; 
	public final int CITYBUILDINGS = 2;
	public final int COTTAGE = 3;
	public String NAME;
	
	private ArrayList<Building> theBuildings = new ArrayList<Building>();
	private ArrayList<CityProperty> theCityBuildings = new ArrayList<CityProperty>();
	private ArrayList<Cottage> theCottages = new ArrayList<Cottage>();
	
	public EstateAgent(String arg) {
		NAME = arg;
	}
	
	public String addBuilding(Building arg) {
		theBuildings.add(arg);
		String output = "";
		if (arg instanceof CityProperty) {
			output = "Added city building";
		}
		else if (arg instanceof Cottage) {
			output = "Added cottage";
		}
		return output;
	}
	
	public String sort(int arg) {
		System.out.println("Sorting by price (1) or Area (2)?");
	}
	
	public static int input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	//Creates a bufferreader called reader that reads the inputs from person to an String
		int arg = Integer.parseInt(reader.readLine());		//creates an arg from the input and changes the String from the bufferreader to an integer
		return arg;			//returns the int from where it was called from
	}

}
