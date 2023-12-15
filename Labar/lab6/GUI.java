package lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class GUI extends JFrame implements ActionListener {
	
	private JButton lPhonebook; //Buttons
	private JButton sPhonebook;
	private JButton search;
	private JButton nextName;
	private JButton addPerson;
	private JButton deletePerson;
	
	private JTextField top; //TextField
	private JTextField middle;
	private JTextField bottom;
	
	private PhoneBook telefonLista = new PhoneBook();  //The loaded phone book
	ArrayList<Person> lucas = new ArrayList<Person>(); //Our temporary search array when using nextName button
	private int counter = 1; //Counter that keeps track of how many times we pressed nextName button
	boolean doublePress = true; //A counter but in boolean type, for the addPerson method
	
	public GUI() {
		
		//Misc
		Font theFont = new Font("SansSerif", Font.PLAIN, 20); //Sets font
		setVisible(true); 		
		setTitle("Interactive phonebook");
		Container c = getContentPane(); //Create a container where we add all of our buttons and textfields
		c.setLayout(new GridLayout(3,2)); //In math 3 rows, 2 colons
		
		//Initialize
		top = new JTextField();
		middle = new JTextField();
		bottom = new JTextField();
		lPhonebook = new JButton("Load phonebook");		
		sPhonebook = new JButton("Save phonebook");
		search = new JButton("Search");
		nextName = new JButton("Next name");
		addPerson = new JButton("Add Person");
		deletePerson = new JButton("Delete person");

		// Set so middle and bottom button not editable
		middle.setEditable(false);
		bottom.setEditable(false);
		
		//setEnabled or not
		top.setEnabled(true);
		middle.setEnabled(true);		
		bottom.setEnabled(true);
		lPhonebook.setEnabled(true);
		sPhonebook.setEnabled(false);
		search.setEnabled(false);
		nextName.setEnabled(false);
		addPerson.setEnabled(false);
		deletePerson.setEnabled(false);
		
		//Set the font
		top.setFont(theFont);
		middle.setFont(theFont);
		bottom.setFont(theFont);
		lPhonebook.setFont(theFont);
		sPhonebook.setFont(theFont);
		search.setFont(theFont);
		nextName.setFont(theFont);
		addPerson.setFont(theFont);
		deletePerson.setFont(theFont);
		
		//Set to the ActionListener reacts when button is pressed
		top.addActionListener(this);
		middle.addActionListener(this);
		bottom.addActionListener(this);
		lPhonebook.addActionListener(this);
		sPhonebook.addActionListener(this);
		search.addActionListener(this);
		nextName.addActionListener(this);
		addPerson.addActionListener(this);
		deletePerson.addActionListener(this);		
		
		//Add the elements
		c.add(lPhonebook);
		c.add(sPhonebook);
		c.add(top);
		c.add(search);		
		c.add(nextName);
		c.add(middle);
		c.add(addPerson);
		c.add(deletePerson);
		c.add(bottom);
		
		// Pack everything together
		pack();		
		//Stop run code when exiting GUI
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
	public void actionPerformed(ActionEvent ae) {
		String temp = "";		

		if (ae.getSource() == lPhonebook || ae.getSource() == top) { //When Pressing LoadButton or enter
			doublePress = false; //Reset addPerson button				
			temp = telefonLista.load(top.getText()); //loads file, contains try catch 
			middle.setText(temp);
				if (temp.equals("Try Again")) {
					sPhonebook.setEnabled(false);
					search.setEnabled(false);
					addPerson.setEnabled(false);
					deletePerson.setEnabled(false);	
				} else if (temp.equals("Phonebook loaded")) { //If loaded enable the other buttons
				top.setText("");
				bottom.setText("");
				sPhonebook.setEnabled(true);
				search.setEnabled(true);
				addPerson.setEnabled(true);
				deletePerson.setEnabled(true);				
			}		
			
		}
		if (ae.getSource() == sPhonebook) { //When pressing Save phone book
			doublePress = false; //Reset addPerson booleon
			temp = top.getText();			
			
			if (temp.isBlank() || temp.equals("PhoneList.txt")) { 
				middle.setText("Provide file namn");
				bottom.setText("");
			} else {
				temp = telefonLista.save(temp); //Contains try catch
				middle.setText(temp);	
			}			
		}
		
		if (ae.getSource() == search) {	//When pressing Search button
			doublePress = false; //Reset		
			lucas.clear(); //Reset
			counter = 1; //Reset
			
			temp = top.getText();
			lucas = telefonLista.search(temp); //Searches for person and return array
			if (lucas.isEmpty()) {
				bottom.setText("Provide a name or number");
				middle.setText("");
			} else if (lucas.size() == 1) { //If search method only found one display and don't turn on nextName
					middle.setText(lucas.get(0).getFullName());
					bottom.setText(Integer.toString(lucas.get(0).getPhoneNumber()));
			}
			else if (lucas.size() > 1) { //If found more than one enable nextName
				nextName.setEnabled(true);
				middle.setText(lucas.get(0).getFullName());
				bottom.setText(Integer.toString(lucas.get(0).getPhoneNumber()));
			}		
		}	
		if (ae.getSource() == nextName) { //When pressing nextName
			if (counter >= lucas.size() || lucas.size() == 1) { //If Counter is bigger than the persons found
				nextName.setEnabled(false); //then disable button otherwise array out of bounds exception
				counter = 1;
				
			} else {
				middle.setText(lucas.get(counter).getFullName());
				bottom.setText(Integer.toString(lucas.get(counter).getPhoneNumber()));
				counter += 1;
				if (counter >= lucas.size()) { //Then check again if counter bigger than array then disable button
					nextName.setEnabled(false);
				}
			}	
		}
		if (ae.getSource() == deletePerson) {
			doublePress = false;
			try {
				top.setText(telefonLista.deletePerson(middle.getText(), Integer.parseInt(bottom.getText())));
				middle.setText("");
				bottom.setText("");
				if (lucas.size() == 1) {
					nextName.setEnabled(false);
				}
			}catch (Exception e) {
				top.setText("Can't find person");
			}
			temp = middle.getText() + " " + bottom.getText();
			
		}
		
		if (ae.getSource() == addPerson) {
			if (!doublePress) {
				top.setText("Type in name and number");
				middle.setText("");
				middle.setEditable(true);
				bottom.setText("");
				bottom.setEditable(true);				
				doublePress = true;				
			} else {
				try {
					boolean answer = telefonLista.addPerson(middle.getText(), Integer.parseInt(bottom.getText()));
					middle.setText("");
					bottom.setText("");
					middle.setEditable(false);					
					bottom.setEditable(false);
					doublePress = false;
					if (answer) {
						top.setText("Person added");
					} else {
						top.setText("Person could not be added");
					}					
				} catch (Exception e) {
					top.setText("Something went wrong");
					middle.setEditable(false);					
					bottom.setEditable(false);
				}
			}
		}		
	}

	public static void main(String[] args) throws IOException{
		GUI g = new GUI();		

	}
}
	

