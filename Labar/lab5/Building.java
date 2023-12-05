package lab5;

public abstract class Building implements Comparable<Building>{
	private String adress;
	private double price;
	protected int squareMeters ;
	protected static int selection = 1;
	
	public Building(String arg1, double arg2, int arg3) {
		adress = arg1;
		price = arg2;
		squareMeters = arg3;
	}
	
	public abstract double maintenance();
	
	public int compareTo(Building arg) {
		if (selection == 1) {
			if (price == arg.price) {
				return 0;
			}
			else if (price < arg.price) {
				return -1;
			} else {
				return 1;
			}			
		}
		else {
			if (squareMeters == arg.squareMeters) {
				return 0;
			}
			else if (squareMeters < arg.squareMeters) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	public String toString() {
		return String.format("Adress: %16s, Living area: %4d, Price: %10.2f, Maintenance (per month): %7.2f", adress, 
				squareMeters, price, maintenance());
	}

}
