package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class EstateAgent {
	public final int ALLBUILDINGS = 1; 
	public final int CITYBUILDINGS = 2;
	public final int COTTAGES = 3;
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
	
	public String sort(int arg) throws IOException {
		System.out.println("Sorting by price (1) or Area (2)?");
		String output = "";
		int answer = input();
		Building.selection = answer;
		
		if (arg == ALLBUILDINGS) {
			
			Collections.sort(theBuildings);
			updateLists();
			
		} else if(arg == COTTAGES) {
			
			Collections.sort(theCottages);
			updateLists(COTTAGES);
			
		} else if(arg == CITYBUILDINGS) {
						
			ArrayList<Building> temp = new ArrayList<Building>(); 
			
			for(int pass = 0; pass < theCityBuildings.size(); ++pass) {
				temp.add((Building) theCityBuildings.get(pass)); 
			}
			
			Collections.sort(temp);
			theCityBuildings.clear();
			
			for(int pass = 0; pass < temp.size(); ++pass) {
				theCityBuildings.add((CityProperty) temp.get(pass));
			}

			updateLists(CITYBUILDINGS);
		}
		
		if (answer == 1) {
			output = "Sorted by price";
		} else if (answer == 2) {
			output = "Sorted by area";
		} else {
			output = "Not sorted";
		}
		
		return output;
	}
	
	public static int input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int arg = Integer.parseInt(reader.readLine());		//creates an arg from the input and changes the String from the bufferreader to an integer
		if (arg == 1 || arg == 2) {
				return arg;
		} else {
			System.out.println("Wrong input!\nSorting by price (1) or Area (2)?");
			return input();
		}
	}
	
	public void updateLists() {
		Collections.sort(theCottages);
		
		ArrayList<Building> temp = new ArrayList<Building>(); 
		
		for(int pass = 0; pass < theCityBuildings.size(); ++pass) {
			temp.add((Building) theCityBuildings.get(pass)); 
		}
		
		Collections.sort(temp);
		theCityBuildings.clear();
		
		for(int pass = 0; pass < temp.size(); ++pass) {
			theCityBuildings.add((CityProperty) temp.get(pass)); 
		}
		
	}
	
	public void updateLists(int arg) {
		if (arg == COTTAGES) {
			int cottage_counter = 0;
			for (int pass = 0; pass < theBuildings.size(); ++pass) {
				if(theBuildings.get(pass) instanceof Cottage) {
					theBuildings.set(pass, theCottages.get(cottage_counter));
					++cottage_counter;
				}
			}
		} else {
			int city_counter = 0;
			for (int pass = 0; pass < theBuildings.size(); ++pass) {
				if(theBuildings.get(pass) instanceof CityProperty) {
					theBuildings.set(pass, (Building)theCityBuildings.get(city_counter));
					++city_counter;
				}
			}
			
		}
	}

}
