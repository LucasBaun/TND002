package lab3;

public class CurrentAccount extends Account {

	
	/*
	 * En konstruktor som tar kundens namn och ett initialt saldo som argument och skapar ett nuvarande konto.
	 * Den använder konstruktorn från den överordnade klassen Account genom super(arg1, arg2) och sätter otherAccount till null.
	 */
	public CurrentAccount(String arg1, double arg2) {
		super (arg1, arg2);
		otherAccount = null;		
	}
	
	/*
	 *  En annan konstruktor som tar ett tredje argument, ett räntesats för ett sparakonto.
	 *  Den använder konstruktorn från den överordnade klassen Account genom super(arg1, arg2, arg3).
	 */
	public CurrentAccount(String arg1, double arg2, double arg3) {
		super (arg1, arg2, arg3);
		
	}
	
	/*En metod som används för att överföra pengar mellan nuvarande konto och spar-/konto.
	Den tar en summa som argument och utför överföringen baserat på olika villkor.
	
	Om summan är positiv överförs pengar från nuvarande konto till spar-/konto.
	Om summan är negativ överförs pengar från spar-/konto till nuvarande konto.
	
	Om summan är mindre än eller lika med saldot på nuvarande konto, överförs hela summan.
	Om summan är större än saldot på nuvarande konto, överförs hela saldot, och nuvarande konto nollställs.
	
	Transaktioner registreras i transactions för både nuvarande konto och spar-/konto.
	*/
	public void savings(double arg1) {
		double temp;
		if(!(this.getSavingsAccount() == null)) {
			if(arg1 > 0) {
				if(arg1 <= this.getBalance()) {
					temp = this.getBalance() - arg1;
					this.setBalance(temp);
					
					this.transactions.add("To savings account: " + arg1);
					otherAccount.transactions.add("From current account: " + arg1);
					
					temp = otherAccount.getBalance() + arg1;
					otherAccount.setBalance(temp);			
					
				}
				else {
					temp = this.getBalance();
					this.setBalance(0);
					
					this.transactions.add("To savings account: " + temp);
					otherAccount.transactions.add("From current account: " + temp);
					
					temp = otherAccount.getBalance() + temp;
					otherAccount.setBalance(temp);					
				}
				
			}
			if(arg1 <= 0 ) {
				if (arg1 <= otherAccount.getBalance()) {
					temp = this.getBalance() - arg1;
					this.setBalance(temp);
					
					this.transactions.add("From savings account: " + -(arg1));
					otherAccount.transactions.add("To current account: " + -(arg1));
					
					temp = otherAccount.getBalance() + arg1;
					otherAccount.setBalance(temp);	
				}
				else {
					temp = otherAccount.getBalance();
					otherAccount.setBalance(0);
					
					this.transactions.add("From savings account: " + temp);
					otherAccount.transactions.add("To current account: " + temp);
					
					temp = this.getBalance() + temp;
					this.setBalance(temp);	
				}				
			}
		}		
	}
}
