package lab1test;

public class Lab1b {

	public static void main(String[] args) {
		
		System.out.println(Vector.vdef);		
		Vector v1 = new Vector();		
		System.out.println(v1);
		
		Vector.setDefault(new Vector(1.0, 2.0, 3.0));
		
		v1.setToDefault();
		
		System.out.println(v1);
		
		Vector v2 = new Vector(1.0,1.0,2.0);
		
		System.out.println(v2);
		
		System.out.println(v1.length());
		
		double[][] m1 =  {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0,1.0}};
		
		System.out.println(v1.matrixMult(m1));
		
		double[][] m2 = {{1.0, 0.0}, {0.0, 1.0}};
		
		System.out.println(v1.matrixMult(m2));
		
		double[][] m3 = {{0.0, 1.0, 0.0}, {1.0, 0.0, 0.0}, {0.0, 0.0, 1.0}};
		
		System.out.println(v1.matrixMult(m3));
		
		System.out.println(Vector.plus(v1, v2));
		
		System.out.println(v1.minus(v2));
		
		System.out.println(v1.mult(2));
		
		System.out.println(v1.mult(v2));
		
		System.out.println(v1.compareTo(v2));
		
		v1.norm();
		v2.norm();
		
		System.out.println(v1.mult(v2));
		System.out.println(v2.mult(v2));
		
		

	}

}
