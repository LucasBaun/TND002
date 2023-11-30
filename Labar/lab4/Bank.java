package lab4;
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
			if (!(theLoans.isEmpty())) {
				for (Loan temp : theLoans) {	
					if(temp.getCustomer().equals(arg)) {
					double loan = temp.getBalance();					
					result += temp.toString();
					}
				}				
			}
			return result;
		}

		return "Person does not exist";  		
	}
	
	public void transfer(String arg1, String arg2, double arg3) {
		if (this.searchAccount(arg1) != null && this.searchAccount(arg2) != null) {
			CurrentAccount temp = searchAccount(arg1);
			CurrentAccount temp2 = searchAccount(arg2);
			
			//temp2.setBalance(temp2.getBalance() + arg3);			
			//temp.send(temp.getBalance()-arg3, temp2);
			temp.send(arg3, temp2);
			
		}
	}
	
	public void getLoan(CurrentAccount arg) {		
		Loan temp = new Loan(arg);
		theLoans.add(temp);		
	}
	
	public void cashPayment(String arg1, double arg2) {
		
		for (int pass = 0; pass < theLoans.size(); pass++) {
			if (theLoans.get(pass).getCustomer().equals(arg1)) {
				if (arg2 >= 0) {
					arg2 = theLoans.get(pass).payOff(arg2);
					if(arg2 >= 0) {
						theLoans.remove(pass);
						pass--;
					}
				}			

			}
		}
		if (arg2 > 0) {
			searchAccount(arg1).receive("Cash payment", arg2);
		}
	}

	public void computeAnnualChange() {
		for (Account a : theAccounts) {
			a.annualChange();
		}
		for (Loan l : theLoans) {
			l.annualChange();
		}
	}
	
	public String toString () {
		double current = 0;
		double saving = 0;
		double totalloan = 0;
		
		for (int pass = 0; pass < theAccounts.size(); ++pass) {
			if(theAccounts.get(pass) instanceof CurrentAccount) {
				current += theAccounts.get(pass).getBalance();
			}
			
			if(theAccounts.get(pass) instanceof SavingAccount) {
				saving += theAccounts.get(pass).getBalance();
			}
	
			
		}
		if (theLoans.size() > 0) {			
			for (Loan l : theLoans) {
				totalloan += l.getBalance();
			}
		}
		
		
		return "Bank:" + NAME + "\n" + "Accounts: " + theAccounts.size() + "\nLoans: " + theLoans.size() + "\n" 
		+"Money in current / savings accounts and debt: " + current + " / " + saving + " / " + totalloan;
		
	}


}
 