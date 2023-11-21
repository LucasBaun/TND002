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
		if(!this.getSavingsAccount().equals(null)) {
			if(arg1 > 0) {
				if(arg1 <= this.getBalance()) {
					double temp = this.getBalance() - arg1;
					this.setBalance(temp);
					
					
				}
			}
			if(arg1 <= 0 ) {

				//text
			}
		}
		
	}
}
