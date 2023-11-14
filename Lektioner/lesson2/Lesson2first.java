package lesson2;
import java.util.ArrayList;

public class Lesson2first {

	private static ArrayList<Human> classArray1=null;
	public static ArrayList<Human> classArray2=null;
	
	public static void main(String[] args) {
		ArrayList<Human> instanceArray = new ArrayList<Human>();
		
		new Human("Cesar",12,classArray1);
		new Human("Lucas",22,classArray1);
		System.out.println("Hi");
		System.out.println("\n" + classArray1 + "\n");
		
		/*Human h1 = new Human("Mark",30);
		h1.setPosition(0);
				
		instanceArray.add(h1);
		
		String[] firstStep = h1.toString().split(",");
		String[] secondStep = firstStep[0].split(" +");
		
		int pos = Integer.parseInt(secondStep[1]);
		
		secondStep=firstStep[1].split(" +");
		String name = secondStep[1];
		
		secondStep=firstStep[2].split(" +");
		System.out.println(secondStep[2]); 	//Debug print
		int age = Integer.parseInt(secondStep[2]);
		
		instanceArray.add(new Human(name,age));*/
	}
		public void addToArray(Human arg) {
			if (classArray1==null) {
				classArray1= new ArrayList<Human>();
			}
			
			classArray1.add(arg);
		}
		
	
	
}
