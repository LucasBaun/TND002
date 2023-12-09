package lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class GUI extends JFrame implements ActionListener {
	private PhoneBook telefonLista;
	
	private JButton lPhonebook = new JButton("Load phonebook");		
	private JButton sPhonebook = new JButton("Save phonebook");
	private JButton search = new JButton("Search");
	private JButton nextName = new JButton("Next name");
	private JButton addPerson = new JButton("Add Person");
	private JButton deletePerson = new JButton("Delete person");
	
	private JTextField top = new JTextField();
	private JTextField middle = new JTextField();
	private JTextField bottom = new JTextField();
	
	public GUI() {
		telefonLista = new PhoneBook();
		Font theFont = new Font("SansSerif", Font.PLAIN, 20);
//		setSize(800,400);
		setVisible(true);		
		setTitle("Interactive phonebook");
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,2));

		top.setFont(theFont);
		middle.setFont(theFont);
		bottom.setFont(theFont);
		middle.setEnabled(false);
		bottom.setEnabled(false);
		top.addActionListener(this);
		middle.addActionListener(this);
		bottom.addActionListener(this);

		lPhonebook.setEnabled(true);
		sPhonebook.setEnabled(false);
		search.setEnabled(false);
		nextName.setEnabled(false);
		addPerson.setEnabled(false);
		deletePerson.setEnabled(false);
		
		lPhonebook.setFont(theFont);
		sPhonebook.setFont(theFont);
		search.setFont(theFont);
		nextName.setFont(theFont);
		addPerson.setFont(theFont);
		deletePerson.setFont(theFont);
		
		lPhonebook.addActionListener(this);
		sPhonebook.addActionListener(this);
		search.addActionListener(this);
		nextName.addActionListener(this);
		addPerson.addActionListener(this);
		deletePerson.addActionListener(this);
		
		
		
		c.add(lPhonebook);
		c.add(sPhonebook);
		c.add(top);
		c.add(search);		
		c.add(nextName);
		c.add(middle);
		c.add(addPerson);
		c.add(deletePerson);
		c.add(bottom);
		

		pack();		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
	public void actionPerformed(ActionEvent ae) {
		
		String temp = "";
		
		ArrayList<Person> lucas = new ArrayList<Person>();
		if (ae.getSource() == lPhonebook || ae.getSource() == top) {
				try {
					temp = telefonLista.load(top.getText());
					middle.setText(temp);
				
				} catch (IOException e) {
					System.out.println("Failed to load");
			}
			
			if (temp.equals("Phonebook loaded")) {
				top.setText("");
				bottom.setText("");
				sPhonebook.setEnabled(true);
				search.setEnabled(true);
				addPerson.setEnabled(true);
				deletePerson.setEnabled(true);				
			}		
			
		}
		if (ae.getSource() == sPhonebook) {
			temp = "";
			temp = top.getText();			
			
			if (temp.equals("")) {
				middle.setText("Provide file namn");
				bottom.setText("");
			} else {
				try {
					temp = telefonLista.save(temp);
					middle.setText(temp);
				} catch (IOException e) {
					System.out.println("Failed");
				}
			}
			
		}
		if (ae.getSource() == search) {
			System.out.println("Works");
			
			temp = "";
			temp = top.getText();
			
			lucas = telefonLista.search(temp);
			if (lucas.isEmpty()) {
				bottom.setText("Provide a name");
			} else {
				if (lucas.size() == 1) {
					middle.setText(lucas.get(0).getFullName() + " " + lucas.get(0).getPhoneNumber());
				}
				else if (lucas.size() > 1) {
					nextName.setEnabled(true);
					nextName.doClick();
					
				}
			}	
			top.setText("");

		}
//		int counter = 0;
//		if (ae.getSource() == nextName) {
//			
//			
//			middle.setText(lucas.get(counter).getFullName());
//			bottom.setText(Integer.toString(lucas.get(counter).getPhoneNumber()));
//			counter =+ 1;
//			System.out.println("counter increase");
//			
//		}

	}
	
}
