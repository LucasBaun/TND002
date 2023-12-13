package lab3;
import java.util.*;
public class Bank {
	public final String NAME; //En konstant (final) variabel som håller bankens namn.
	private ArrayList<Account> theAccounts = new ArrayList<Account>(); //En lista av konton som tillhör banken.
	
	/*
	 * En konstruktor som tar en sträng som representerar bankens namn. 
	 * Den skapar också en ny instans av banken och sätter bankreferensen för kontona genom att anropa "Account.setBank(this)"
	 */
	public Bank (String arg){
		NAME = arg;
		Account.setBank(this);
	}
	
	//Söker efter ett konto med hjälp av kundens namn och returnerar ett nuvarande konto (CurrentAccount) om det hittas.
	public CurrentAccount searchAccount(String arg) {
		for (int pass = 0; pass < theAccounts.size(); ++pass) {
			if (arg.equals(theAccounts.get(pass).getCustomer())) {
					return (CurrentAccount) theAccounts.get(pass);			
			}	
		}
		return null;		
	}
	
	//Skapar ett nuvarande konto och ett spar-/konto för en person om det inte redan finns konton för personen.
	public String createAccount(String arg1, double arg2, double arg3) {
		if (searchAccount(arg1) == null) {
			CurrentAccount temp = new CurrentAccount(arg1, arg2, arg3);
			theAccounts.add(temp);
			theAccounts.add(temp.otherAccount);
		
			return "Current and savings accounts created for " + arg1;
		
		} else {
			return "Account(s) already exist for" + arg1;
		}
	}
	
	//Skapar ett nuvarande konto och ett spar-/konto för en person med ett givet saldo om det inte redan finns konton för personen.
	public String createAccount(String arg1, double arg2) {
		if (searchAccount(arg1) == null) {
			CurrentAccount temp = new CurrentAccount(arg1, arg2);
			theAccounts.add(temp);
			return "Current and savings accounts created for " + arg1;
		} else {
			return "Account(s) already exist for" + arg1;
		}
	}
	
	//Överför en viss summa från nuvarande konto till spar-/konto för en given person.
	public void currentToSavings(String arg1, double arg2) {
		searchAccount(arg1).savings(arg2);
	}
	
	//Kontrollerar informationen om en person, inklusive nuvarande och spar-/konto om de finns.
	public String checkPerson(String arg) {
		String result = arg + "\n\n";
		if (!searchAccount(arg).equals(null)) {
			
			result += searchAccount(arg).toString() + "\n";
			
			if (!(searchAccount(arg).getSavingsAccount() == null)) {
				result += searchAccount(arg).otherAccount.toString();
			}
			return result;
		}	
		return "Person does not exist";  		
	}
	
	// Skapar en strängrepresentation av banken, inklusive namnet, antalet konton och totala pengar i nuvarande och spar-/konton.
	public String toString () {
		double current = 0;
		double saving = 0;
		
		for (int pass = 0; pass < theAccounts.size(); ++pass) {
			if(theAccounts.get(pass) instanceof CurrentAccount) {
				current += theAccounts.get(pass).getBalance();
			}
			
			if(theAccounts.get(pass) instanceof SavingAccount) {
				saving += theAccounts.get(pass).getBalance();
			}
			
		}
		
		
		return "Bank:" + NAME + "\n" + "Accounts: " + theAccounts.size() + " Money in current / savings accounts: "
				+ current + " / " + saving;
		
	}


}
