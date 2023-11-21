package lab3;

public class Account {

	private static int accountNumbers = 1;
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
	
	public Account(String arg1, double agr2, double arg3) {
		customer = arg1;
		balance = arg2;
		
		
		
	}
	
}
