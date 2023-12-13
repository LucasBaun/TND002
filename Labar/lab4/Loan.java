package lab4;

public class Loan extends Account{
	
	public Loan (CurrentAccount arg) {		
		super(arg);
	}
	
	
	/*
	 	Metoden payOff används för att betala av en del av lånet.
		Den tar emot ett belopp (arg) och ökar lånesaldot med detta belopp.
		Transaktionen läggs till i listan över transaktioner (this.transactions).
		Funktionen returnerar det uppdaterade lånesaldot.
	 */
	public double payOff(double arg) {		
		
		double result = this.getBalance() + arg;
		this.setBalance(result);
		this.transactions.add("Paid of " + arg);
		return result;
	}

}
