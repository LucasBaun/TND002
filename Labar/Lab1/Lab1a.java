package lab1;

public class Lab1a {

	public static void main(String[] args) {
		double[] da1 = {1.0, 2.0, 3.0};
		double[] da2 = {0.0, -0.5, -2.0};
		System.out.println(da1); //Prints out the adress of the vector
		
		System.out.println(addition(da1, da2));
		System.out.println(substract(da1, da2));
		printVector(da1);	
		

	}
	
	static double[] addition(double[] arg1, double[] arg2) {
		double[] arg3 = new double[3];
		
		for (int pass = 0; pass < arg1.length; ++pass) {
			
			arg3[pass] = arg1[pass] + arg2[pass];
		}
		
		return arg3;
	}
	
	static double[] substract(double[] arg1, double[] arg2) {
		double[] arg3 = new double[3];
		for (int pass = 0; pass < arg1.length; ++pass) {
			arg3[pass] = arg2[pass] - arg1[pass];
		}		
		
		return arg3;
	}
	
	static void printVector(double[] arg) {
		String result = new String("Vector = (");
		if (arg.length == 3) {
			for (int pass = 0; pass < arg.length; ++pass) {
				String s;
				s = String.format("%2.1f", arg[pass]);
				result = result + s;
				if (pass != arg.length-1) {
					result = result + ",";
				}
			}
			System.out.println(result + ")");
		}
	
	}	

}
