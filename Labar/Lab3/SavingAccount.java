package lab3;

public class SavingAccount extends Account{

	/*
	 * En konstruktor som tar kundens namn och ett initialt saldo som argument och skapar ett sparakonto.
	 * Den använder konstruktorn från den överordnade klassen Account genom super(arg1, arg2).
	 */
	public SavingAccount(String arg1, double arg2) {
		super(arg1, arg2);
	}
	
}
