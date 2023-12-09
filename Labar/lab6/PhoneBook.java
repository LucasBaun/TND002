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
	
	public String load(String arg) throws IOException{
		File myFile = new File(arg);
		if (!myFile.canRead()) {
			return "Try Again";
		}
		FileReader fRead = new FileReader(myFile);		
		BufferedReader bread = new BufferedReader(fRead);
		String temp = "";		
		String[] statArray;
		while ((temp = bread.readLine()) != null) {
			statArray = temp.split("\\s");
			if (statArray.length == 3) {
				try {				
					listOfNumbers.add(new Person(statArray[0], statArray[1], Integer.parseInt(statArray[2])));
//					System.out.println(statArray[0] + statArray[1] + Integer.parseInt(statArray[2]));
				
				} catch (NumberFormatException ierr) {
					bread.close();
					return "Try Again : " + ierr.getMessage();
				}
			}

			
		}

		bread.close();
		return "Phonebook loaded";	
	}
	
	public ArrayList<Person> search(String arg) {
		ArrayList<Person> temp = new ArrayList<Person>();
		for (Person check : listOfNumbers) {		
			if (check.getSurname().equals(arg) || Integer.toString(check.getPhoneNumber()).equals(arg)) {
				temp.add(check);
			}
		}
		return temp;
	}
	
	public String deletePerson(String arg1, int arg2) {
		ArrayList<Person> temp = new ArrayList<Person>();
		temp = search(Integer.toString(arg2));
		for (Person same : temp) {
			if (arg1.equals(same.getFullName())) {
				for (int pass = 0; pass < listOfNumbers.size(); ++pass) {
					if (listOfNumbers.get(pass).equals(same)) {
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
		temp = search(Integer.toString(arg2));
		
		if (temp.isEmpty()) {
			name = arg1.split(" +");
			if(name.length == 2) {
				for (Person check : temp) {
					if (check.getPhoneNumber() == arg2) {
						
					}
				}
				listOfNumbers.add(new Person(name[0], name[1], arg2));
				return true;				
			}
		}
		return false;		
	}
	
	public String save(String arg) throws IOException{
		BufferedWriter Wread = new BufferedWriter(new FileWriter(arg));
		String output = "";
		for (int pass = 0; pass < listOfNumbers.size(); ++pass) {
			output += listOfNumbers.get(pass).getFullName() + " " +listOfNumbers.get(pass).getPhoneNumber() + "\n";
		}
		try {
			Wread.write(output);
		} catch (IOException e) {
			Wread.close();
			return "Could not save to the file";
		}
		Wread.close();
		return "Saved " + listOfNumbers.size() + " people to the file.";
	}
	


}
