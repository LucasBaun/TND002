package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.FocusListener;

public class GUI extends JFrame implements ActionListener {

	private JButton plus; //Buttons
	private JButton minus;
	private JButton equals;
	private JButton devide;
	private JButton multiply;
	private JButton clear;
	
	private JTextField input; //input and text
	
	public double temp = 0; //sum of the calculation
	public String lastAction = "";
	public Double Dtemp = (double) 0;
	
	public GUI(){
		Font theFont = new Font("SansSerif", Font.PLAIN, 50);
        Font boldFont = new Font("SansSerif", Font.BOLD, 40);
        setVisible(true);
        setTitle("Calculator");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // Initialize
        input = new JTextField();
        plus = new JButton("+");
        minus = new JButton("-");
        equals = new JButton("=");
        devide = new JButton("/");
        multiply = new JButton("*");
        clear = new JButton("AC");

        input.setEnabled(true);
        plus.setEnabled(true);
        minus.setEnabled(true);
        equals.setEnabled(true);
        devide.setEnabled(true);
        multiply.setEnabled(true);
        clear.setEnabled(true);

        input.setFont(boldFont);
        plus.setFont(theFont);
        minus.setFont(theFont);
        equals.setFont(theFont);
        devide.setFont(theFont);
        multiply.setFont(theFont);
        clear.setFont(theFont);
        
        clear.setBackground(Color.decode("#ff9b9b"));

        plus.addActionListener(this);
        minus.addActionListener(this);
        equals.addActionListener(this);
        devide.addActionListener(this);
        multiply.addActionListener(this);
        clear.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
        buttonPanel.add(clear);
        buttonPanel.add(equals);
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(devide);
        buttonPanel.add(multiply);

        c.add(input, BorderLayout.NORTH);
        c.add(buttonPanel, BorderLayout.CENTER);
        
        input.setPreferredSize(new Dimension(400, 100));  // Adjust width and height as necessary
        
        ImageIcon icon = new ImageIcon("calculator-icon-31.jpg");
        setIconImage(icon.getImage());


        
        pack();
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	public void actionPerformed(ActionEvent ae) {
		
	    if (ae.getSource() == clear) {
	        input.setText(""); //clears the textbox
	        temp = 0; //sets temp to 0 (sum)
	        lastAction = ""; //sets last action to 0
	        Dtemp = (double) 0; //sets the Double temp to 0
	    }

	    if (ae.getSource() == equals) {
	        double currentInput = Double.parseDouble(input.getText()); //makes a double with the value of the current input

	        temp = calculate(lastAction, temp, currentInput); //calls the calculate 

	        input.setText(Double.toString(temp)); //prints out temp
	        lastAction = ""; //sets last action to nothing
	        Dtemp = (double) 0; //sets the Double temp to 0
	    }

	    if (ae.getSource() == plus) { //button + was pressed
	        double currentInput = Double.parseDouble(input.getText()); //Makes a double of the value in input

	        temp = calculate(lastAction, temp, currentInput); //calls the calculate 

	        input.setText(""); //removes the text
	        lastAction = "plus"; //sets last action to plus
	    }

	    if (ae.getSource() == minus) { //button - was pressed
	        double currentInput = Double.parseDouble(input.getText()); //creates an double of the input

	        temp = calculate(lastAction, temp, currentInput); //calls the calculate 

	        input.setText(""); //removes the text
	        lastAction = "minus"; //sets last action to minus
	    }
	    
	    if (ae.getSource() == devide) {
	        double currentInput = Double.parseDouble(input.getText()); //creates an double of the input

	        temp = calculate(lastAction, temp, currentInput); //calls the calculate 
	        
	        input.setText(""); //removes the text
	        lastAction = "devide";
	    }
	    
	    if (ae.getSource() == multiply) {
	        double currentInput = Double.parseDouble(input.getText()); //creates an double of the input

	        temp = calculate(lastAction, temp, currentInput); //calls the calculate 
	        
	        input.setText(""); //removes the text
	        lastAction = "multiply";
	    }
	}
	
	private double calculate(String arg1, double arg2, double arg3) {
		switch(arg1) {
		case "plus":
			return arg2 + arg3;
		case "minus":
			return arg2 - arg3;
		case "devide":
			return arg2 / arg3;
		case "multiply":
			return arg2 * arg3;
		default:
			return arg3;
		} 
		
	}
	
	public static void main(String[] args) throws IOException{
		GUI g = new GUI();		

	}
}

