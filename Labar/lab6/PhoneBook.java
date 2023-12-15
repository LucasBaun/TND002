package lab6;

import java.io.*;
import java.util.*;
public class PhoneBook {
	
	private ArrayList<Person> listOfNumbers;
	
	public PhoneBook() {
		listOfNumbers = new ArrayList<Person>();
	}
	
//	public String getList() {
//		String temp = "";
//		for (int pass = 0; pass < listOfNumbers.size(); ++pass) {
//			temp += listOfNumbers.get(pass).getFullName() + " " + listOfNumbers.get(pass).getPhoneNumber() + "\n";
//		}
//		return temp;
//	}
	
	public String load(String arg) { //Load in File
		listOfNumbers.clear(); //Reset when using GUI load button multiple times
		//Puts arg in to File then tests if File(arg) can read the file
		File myFile = new File(arg);
		if (!myFile.canRead()) {
			return "Try Again";
		}
		String temp = "";				
		try { //Here we create FileReader which reads in ascii and therefor puts i BufferedReader to translate
			String[] statArray = {};
			FileReader fRead = new FileReader(myFile);		
			BufferedReader bread = new BufferedReader(fRead);
			while ((temp = bread.readLine()) != null) { //Bread reads every line and splits in to three elements
				statArray = temp.split("\\s");
				if (statArray.length == 3) { //Add the three element in to dynamic array, but need try
					// catch because we use Integer.parseInt to convert String to int
					listOfNumbers.add(new Person(statArray[0], statArray[1], Integer.parseInt(statArray[2])));//							
				}
			}
			bread.close(); //Close the Reader
			} catch (Exception ierr) {					
				return "Try Again";
			}		
		return "Phonebook loaded";	
	}
	
	public ArrayList<Person> search(String arg) { //Search for person in array
		ArrayList<Person> temp = new ArrayList<Person>();
		for (Person check : listOfNumbers) {		
			if (check.getSurname().equals(arg) || Integer.toString(check.getPhoneNumber()).equals(arg)) {
				temp.add(check); //If found person add it to an temporary array, if found multiple add also to array
			}
		}
		return temp;
	}
	
	public String deletePerson(String arg1, int arg2) { //Deletes person from dynamic array listOfNumbers
		ArrayList<Person> temp = new ArrayList<Person>();
		try { // Try-catch int to string
		temp = search(Integer.toString(arg2)); //Search for the person(s)
		} catch (Exception e) {
			return e.getMessage();
		}
		for (Person same : temp) {
			if (arg1.equals(same.getFullName())) { // if arg1 full name equals the search arrays full name
				for (int pass = 0; pass < listOfNumbers.size(); ++pass) {
					if (listOfNumbers.get(pass).equals(same)) { //then goes through the listOfNumbers and deletes
						//if it finds
						listOfNumbers.remove(pass);
						return "Person deleted";
					}
				}
			} else {
				return "The person/number does not exist";
			}
		}
		return "Bla bla";
	}
	
	public boolean addPerson(String arg1, int arg2) {		
		ArrayList<Person> temp = new ArrayList<Person>();
		String[] name;
		try {
			temp = search(Integer.toString(arg2));
		} catch (Exception e) {
			return false;
		}		
		if (temp.isEmpty()) { //If search method did not find, it will return empty array, then we can add person
			name = arg1.split(" +"); //Split at spaces
			if(name.length == 2) { //Name has to be a first name and a surname, not more or less
				for (Person check : temp) {
					if (check.getPhoneNumber() == arg2) { //if persons number already exist don't add
						return false;
					}
				}
				listOfNumbers.add(new Person(name[0], name[1], arg2));
				return true;				
			}
		}
		return false;		
	}
	
	public String save(String arg) {		
		String output = "";
		try {
			BufferedWriter Wread = new BufferedWriter(new FileWriter(arg)); //Create BufferedWriter which writes to file
			for (int pass = 0; pass < listOfNumbers.size(); ++pass) { //Goes through array and adds to string
				output += listOfNumbers.get(pass).getFullName() + " " +listOfNumbers.get(pass).getPhoneNumber() + "\n";
			}
			Wread.write(output); //Writes
			Wread.close(); //Flush or closes
		} catch (IOException e) {			
			return "Could not save to the file";
		}		
		return "Saved " + listOfNumbers.size() + " people to the file.";
	}
	


}
