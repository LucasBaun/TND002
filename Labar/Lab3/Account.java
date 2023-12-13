package lab3;
import java.util.ArrayList;

public class Account {

	private static int accountNumber = 1; //En statisk variabel som används för att tilldela unika kontonummer till varje konto.
	private String customer; //En variabel som lagrar kundens namn.
	private int thisAccountNumber; //Variabeln som håller det aktuella kontonumret för instansen av klassen.
	private double balance; //Variabel som lagrar saldo för kontot.
	protected static Bank theBank; //En statisk variabel som representerar banken som detta konto tillhör.
	protected Account otherAccount; //En variabel som håller referensen till ett annat konto
	protected ArrayList<String> transactions = new ArrayList<String>();

	//En konstruktor som tar kundens namn och ett initialt saldo som argument och skapar ett konto. Den tilldelar också ett unikt kontonummer.
	public Account(String arg1, double arg2) {
		customer = arg1;
		balance = arg2;
		
		thisAccountNumber = accountNumber;
		accountNumber += 1;
	}
	
	
	//En annan konstruktor som tar ett tredje argument, antagligen ett räntesats för ett sparakonto. Den skapar även ett spar-/konto och kopplar det till detta konto.
	public Account(String arg1, double arg2, double arg3) {
		customer = arg1;
		balance = arg2;
		thisAccountNumber = accountNumber;
		accountNumber +=1;
		SavingAccount account_2 = new SavingAccount(arg1, arg3);
		otherAccount = account_2;
		otherAccount.otherAccount = this;
	}
	
	
	//Returnerar det aktuella kontonumret.
	public int getAccountNumber() {
		return thisAccountNumber;
	}
	
	//Returnerar kundens namn.
	public String getCustomer() {
		return customer;
	}
	
	//Returnerar saldot för kontot.
	public double getBalance() {
		return balance;
	}
	
	//Ändrar saldot för kontot.
	public void setBalance(double arg1) {
		balance = arg1;
	}
	
	//Ställer in vilken bank detta konto tillhör.
	public static void setBank(Bank arg1) {
		theBank = arg1;
	}
	
	//Returnerar spar-/kontot om det finns, annars null.
	public SavingAccount getSavingsAccount() {
		if(otherAccount instanceof SavingAccount) {
			return (SavingAccount) otherAccount;
		}
		else {
			return null;
		}
	} 
	
	
	//Skapar en strängrepresentation av kontot, inklusive kontonummer, saldo och eventuella transaktioner.
	public String toString() {
		String output = "";
		if (this instanceof SavingAccount) {
			output = "Savings Account with account number " + getAccountNumber() + ": " + getBalance() + "\n";
		} else if (this instanceof CurrentAccount) {
			output = "Current Account with account number " + getAccountNumber() + ": " + getBalance() + "\n";
		}
		
		for (int pass = 0; pass < transactions.size(); pass++) {
			output = output + transactions.get(pass) + "\n";
		}
		
		return output;
		
	}
		
	
}
