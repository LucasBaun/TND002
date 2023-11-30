package lab3;

public class CurrentAccount extends Account {

	public CurrentAccount(String arg1, double arg2) {
		super (arg1, arg2);
		otherAccount = null;		
	}
	
	public CurrentAccount(String arg1, double arg2, double arg3) {
		super (arg1, arg2, arg3);
		
	}
	
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
	
	public void send(double arg1, CurrentAccount arg2) {
		transactions.add("Sent to account of " + arg2.getCustomer() + ": " + arg1);
		setBalance(getBalance()- arg1);
		arg2.receive(getCustomer(), arg1);
		
		if (getBalance() < 0) {
			savings(getBalance());
			if (getBalance() < 0) {
				theBank.getLoan(this);
				transactions.add("Covered by loan: " ); //followed by the amount of money you got from the loan to get balance to zero
				setBalance(0);
			}
		}
		
		
		
	}
	
	public void receive(String arg1, double arg2) {
		this.setBalance(this.getBalance() + arg2);
		
		if (arg1.equals("Cash payment")) {
			transactions.add("Cash pay-ment: " + arg2);
		} else {
			transactions.add("Recieved from account of " + arg1 + ": " + arg2);
		}
	}
}
