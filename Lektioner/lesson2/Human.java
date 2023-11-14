package lesson2;
import java.util.ArrayList;

public class Human {
	private int age;
	private String name;
	private int position;
	
	public Human(String arg1, int arg2) {
		name = arg1; age = arg2;
	}
	
	public Human(String arg1, int arg2, ArrayList<Human> arg3) {
		name = arg1; age = arg2;
		Lesson2first temp = new Lesson2first();
		temp.addToArray(this);
		

	}
	
	public void setPosition(int arg) {
		position = arg;
	}
	
	public String toString() {
		return String.format("Position:%2d, Name:%10s, Age:%3d", position,name,age);
	}	
		
}
