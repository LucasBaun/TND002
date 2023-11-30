package lab4;

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
				if (-(arg1) <= otherAccount.getBalance()) {
					temp = this.getBalance() - arg1;
					this.setBalance(temp);
					
					this.transactions.add("From savings account: " + Math.abs(arg1));
					otherAccount.transactions.add("To current account: " + Math.abs(arg1));
					
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
	
	public void receive(String arg1, double arg2) {
		String output = "";
		this.setBalance(this.getBalance() + arg2);
		if (arg1.equals("Cash payment")) {
			output = "Cash payment: " + arg2;
		} else {
			output = "Received from account of " + arg1 + "; " + arg2;
		}
		this.transactions.add(output);
	}	
	
	public void send(double arg1, CurrentAccount arg2) {		
		double temp;
		this.setBalance((getBalance() - arg1));
		arg2.receive(this.getCustomer(), arg1);
		
		this.transactions.add("Sent to account of " + arg2.getCustomer() + ": " + arg1);
		
		if (this.getBalance() < 0) {
			if (this.getSavingsAccount() != null) {
				savings(this.getBalance());
				if (this.getBalance() < 0) {
					temp = this.getBalance();
					theBank.getLoan(this);
					this.transactions.add("Covered by a Loan: " + Math.abs(temp));					
					this.setBalance(0);
				}
				
			}			
		}
		
	}
	
	
}
