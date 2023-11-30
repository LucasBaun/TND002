package lab4;

public class Loan extends Account{
	
	public Loan (CurrentAccount arg) {		
		super(arg);
	}
	
	public double payOff(double arg) {		
		
		double result = this.getBalance() + arg;
		this.setBalance(result);
		this.transactions.add("Paid of " + arg);
		return result;
	}

}
