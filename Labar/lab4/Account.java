package lab4;
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
		balance = arg2;
		thisAccountNumber = accountNumber;
		accountNumber +=1;
		SavingAccount account_2 = new SavingAccount(arg1, arg3);
		otherAccount = account_2;
		otherAccount.otherAccount = this;
	}
	
	public Account(CurrentAccount arg) {		
		this.otherAccount = arg;
		this.balance = arg.getBalance();
		this.thisAccountNumber = arg.getAccountNumber();
		this.customer = arg.getCustomer();
	}
	
	public int getAccountNumber() {
		return thisAccountNumber;
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
		if(otherAccount instanceof SavingAccount) {
			return (SavingAccount) otherAccount;
		}
		else {
			return null;
		}
	}
	
	public void annualChange() {
		if (this instanceof SavingAccount) {
			this.setBalance((this.balance*1.01));
		}
		else if (this instanceof Loan) {
			this.setBalance(this.balance*1.05);
		}
		else if (this instanceof CurrentAccount) {
			this.setBalance(this.balance - 10);
			
			double calc = (this.balance - 10);
			if (calc < 0) {	
				
				theBank.getLoan((CurrentAccount) this);				
				this.setBalance(0);
			}
			
		}
	}
	
	public String toString() {
		String output = "";
		if (this instanceof SavingAccount) {
			output = "Savings Account with account number " + getAccountNumber() + ": " + getBalance() + "\n";
		} else if (this instanceof CurrentAccount) {
			output = "Current Account with account number " + getAccountNumber() + ": " + getBalance() + "\n";
		} else if (this instanceof Loan) {
			output = "Loan:" + getBalance() + "\n";
		}
		
		for (int pass = 0; pass < transactions.size(); pass++) {
			output = output + transactions.get(pass) + "\n";
		}
		
		return output;
		
	}
		
	
}
