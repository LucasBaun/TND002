package lab5;

public abstract class Building implements Comparable<Building>{

	private String address;
	private double price;
	protected int squareMeters;
	protected static int selection = 1;
	
	public Building(String arg1, double arg2, int arg3) {
		address =  arg1;
		price = arg2;
		squareMeters = arg3;
		
	}
	
	public abstract double maintenance();

	public int compareTo(Building arg) {
		int temp = 0;
		if (selection == 1) {
			if (price == arg.price) {
				temp = 0;
			}
			else if (price < arg.price) {
				temp = -1;
			}
			else {
				temp = 1;
			}
		
		} else {
			
			if (squareMeters == arg.squareMeters) {
				temp = 0;
			} else if (squareMeters < arg.squareMeters) {
				temp = -1;
			} else {
				temp = 1;
			}
		}
		return temp;
	}
	
	public String toString(){

	String temp = String.format("Address: %16s,  Living area: %4d,  Price: %10.2f,  Maintenance(per month): %7.2f", address, squareMeters, price, maintenance());
	
	if (this instanceof CityProperty) {
		CityProperty temp2 = (CityProperty)this;
		temp = temp + "\nProperty tax: " + temp2.computePropertyTax();
	}
	return temp;

	}

}
