package lab3;
import java.util.*;
public class Bank {
	public final String NAME;
	private ArrayList<Account> theAccounts = new ArrayList<Account>();
	private ArrayList<Loan> theLoans = new ArrayList<Loan>();
	
	
	public Bank (String arg){
		NAME = arg;
		Account.setBank(this);
	}
	
	public CurrentAccount searchAccount(String arg) {
		for (int pass = 0; pass < theAccounts.size(); ++pass) {
			if (arg.equals(theAccounts.get(pass).getCustomer())) {
					return (CurrentAccount) theAccounts.get(pass);			
			}	
		}
		return null;		
	}
	
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
	
	public String createAccount(String arg1, double arg2) {
		if (searchAccount(arg1) == null) {
			CurrentAccount temp = new CurrentAccount(arg1, arg2);
			theAccounts.add(temp);
			return "Current and savings accounts created for " + arg1;
		} else {
			return "Account(s) already exist for" + arg1;
		}
	}
	
	public void currentToSavings(String arg1, double arg2) {
		searchAccount(arg1).savings(arg2);
	}
	
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
		/*
		  	checkPerson(String) should now also list the loans. It should start the line with
			”Loan: ” followed by the value of balance.
		 */
	}	
	
	
	public void transfer(String arg1, String arg2, double arg3) {
		CurrentAccount customer1 = searchAccount(arg1);
		CurrentAccount customer2 = searchAccount(arg2);
		
		if(customer1 != null && customer2 != null) {
			customer1.send(arg3, customer2);
		}	
	}
	
	
	public String toString () {
		double current = 0;
		double saving = 0;
		double loan = 0;

		for (int pass = 0; pass < theAccounts.size(); ++pass) {
			if(theAccounts.get(pass) instanceof CurrentAccount) {
				current += theAccounts.get(pass).getBalance();
			}
			
			if(theAccounts.get(pass) instanceof SavingAccount) {
				saving += theAccounts.get(pass).getBalance();
			}
			
		}
		
		for (int i = 0; i < theLoans.size(); ++i) {
			loan = loan + theLoans.get(i).getBalance();
		}
		
		
		return "Bank:" + NAME + "\n" + "Accounts: " + theAccounts.size() + " Money in current / savings accounts and dept: "
				+ current + " / " + saving + "/" + loan;
		
	}


}
