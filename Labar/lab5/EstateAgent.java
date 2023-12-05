package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;


public class EstateAgent {
	public static final int ALLBUILDINGS = 1; 
	public static final int CITYBUILDINGS = 2;
	public static final int COTTAGES = 3;
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
			theCityBuildings.add((CityProperty)arg);
			output = "Added city building";
		}
		else if (arg instanceof Cottage) {
			theCottages.add((Cottage)arg);
			output = "Added cottage";
		}
		return output;
	}
	
	public String sort(int arg) throws IOException {
		int temp = 0;
		String input1;
		String temp1;
		String output = "";
		do {
			try {
				input1 = JOptionPane.showInputDialog("Sorting by price (1) or Area (2)?");
				temp1 = input1;
				temp = Integer.parseInt(temp1);
			}
			catch(NumberFormatException ierr) {
				temp1 = "fail";
			}
		} while(temp1.equals("fail"));
		
		Building.selection = temp;
		
		if (arg == ALLBUILDINGS) {
			
			Collections.sort(theBuildings);
			updateLists();
			
		} else if(arg == COTTAGES) {
			
			Collections.sort(theCottages);
			updateLists(COTTAGES);
			
		} else if(arg == CITYBUILDINGS) {
						
			ArrayList<Building> tempis = new ArrayList<Building>(); 
			
			for(int pass = 0; pass < theCityBuildings.size(); ++pass) {
				tempis.add((Building) theCityBuildings.get(pass)); 
			}
			
			Collections.sort(tempis);
			theCityBuildings.clear();
			
			for(int pass = 0; pass < tempis.size(); ++pass) {
				theCityBuildings.add((CityProperty) tempis.get(pass));
			}

			updateLists(CITYBUILDINGS);
		}
		
		if (temp == 1) {
			output = "Sorted by price";
		} else if (temp == 2) {
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
	
	public String toString() {
		String allbuilding = "";
		String allcott = "";
		String allcity = "";
		String tot = "";
		for(int pass = 0; pass < theBuildings.size(); ++pass) {
			allbuilding += theBuildings.get(pass).toString();
		}
		for(int lucas = 0; lucas < theCottages.size(); ++lucas) {
			allcott += theCottages.get(lucas).toString()+"\n";
		}
		for(int linus = 0; linus < theCityBuildings.size(); ++linus) {
			allcity += theCityBuildings.get(linus).toString() + "\n";
		}
		tot = "Estate agent: " + NAME + "\nAll buildings\n" + allbuilding + "\nCottages:\n" + allcott + "\nVillas and apartments:\n" + allcity;
		return tot;
	}

}
