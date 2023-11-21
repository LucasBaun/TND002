package lab3;
import java.util.ArrayList;

public class Account {

	private static int accountNumber = 1;
	private String customer;
	private int thisAccountNumber;
	private double balance;
	protected static Bank theBank;
	protected Account otherAccount;
	protected ArrayList<String> transactions = new ArrayList<String>();

	public Account(String arg1, double arg2) {
		customer = arg1;
		balance = arg2;
		
		thisAccountNumber = accountNumber;
		accountNumber += 1;
	}
	
	public Account(String arg1, double arg2, double arg3) {
		customer = arg1;
		balance = arg3;
		
		//Lite mer saker ska in här men fattar ej vad.
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double arg1) {
		balance = arg1;
	}
	
	public static void setBank(Bank arg1) {
		theBank = arg1;
	}
	
	public SavingAccount getSavingsAccount() {
		if(true) {
			/*
			getSavingsAccount() returns otherAccount if that is a savings account. 
			It returns null if otherAccount is a current account.

			 */
		}
	} 
	
	public String toString() {
		String output = "";
		
	}
		
	
}
