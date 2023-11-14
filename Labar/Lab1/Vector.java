package lab1test;

public class Vector {
	private double x; private double y; private double z;
	
	public static Vector vdef = new Vector(0.0, 0.0, 0.0);
	
	public Vector() {
		setToDefault();
		
	}
	
	public Vector(double d1, double d2, double d3) {
		x = d1;
		y = d2;
		z = d3;
	}
	
	public static void setDefault(Vector arg) {
		vdef.x = arg.x;
		vdef.y = arg.y;
		vdef.z = arg.z;		
	}
	
	public void setToDefault() {
		x = vdef.x;
		y = vdef.y;
		z = vdef.z;
	}
	
	public static Vector plus(Vector arg1, Vector arg2) {
		Vector result = new Vector();
		result.x = arg1.x + arg2.x;
		result.y = arg1.y + arg2.y;
		result.z = arg1.z + arg2.z;
		
		return result;
	}
	
	public Vector minus(Vector arg) {
		Vector result = new Vector();
		
		result.x = x - arg.x;
		result.y = y - arg.y;
		result.z = z - arg.z;
		
		return result;
	}
	
	public Vector mult(double arg) {
		Vector result = new Vector();
		
		result.x = x*arg;
		result.y = y*arg;
		result.z = z*arg;
		
		return result;
	}
	
	public double mult(Vector arg) {
		double result;
		
		result = x*arg.x + y*arg.y + z*arg.z;
		
		return result;
	}
	
	public double length() {
		double result;
		
		result = Math.sqrt(x*x + y*y + z*z);
		
		return result;
	}
	public void norm() {		
		double temp = 1/length();
		
		x = x*temp;
		y = y*temp;
		z = z*temp;
		
	}
	
	public Vector matrixMult(double[][] arg) {
		Vector result = new Vector();
		if (arg.length == 3 && arg[0].length == 3) {
			
			result.x = arg[0][0]*x + arg[0][1]*y + arg[0][2]*z;
			result.y = arg[1][0]*x + arg[1][1]*y + arg[1][2]*z;
			result.z = arg[2][0]*x + arg[2][1]*y + arg[2][2]*z;
			return result;
		}
		else {
			return this;
			
		}
	}
	
	public int compareTo(Vector arg) {
		int result = 0;
		
		if (length() == arg.length()) {
			
		}
		else if (length() > arg.length()) {
			result = 1;
		}
		else if (length() < arg.length()) {
			result = -1;
		}
		
		return result;
	}
	
	public String toString() {
		
		String s = String.format("Vector = (%04.1f, %04.1f, %04.1f)", x, y, z);
		
		return s;
	}
	

}
