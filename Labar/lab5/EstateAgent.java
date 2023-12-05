package lab5;

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
		
	}

}
