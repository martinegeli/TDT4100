package inheritance;

public abstract class AbstractAccount {
	
	protected double account;
	
	protected AbstractAccount() {
		this.account = 0;
	}
	
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Må være positivt innskud");
		}else {
			this.account += amount;
		}
	}

	protected void withdraw(double amount) {
		if (amount < 0) throw new IllegalArgumentException("Må være positivt innskud");
		internalWithdraw(amount);
	}

	public double getBalance() {
		return this.account;
	}
	
	protected abstract void internalWithdraw(double amount);
	
}
