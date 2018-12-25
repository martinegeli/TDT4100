package inheritance;


public class SavingsAccount implements Account{
	
	
	private double account;
	private double rente;
	
	
	protected SavingsAccount(double rente) {
		this.account = 0.0;
		this.rente = rente;
	}
	
	@Override
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Må være positivt innskud");
		}else {
			this.account += amount;
		}
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= 0) throw new IllegalArgumentException("Må være positivt innskud");
		if (amount > this.account) throw new IllegalStateException("Kan ikke få negativ kontobalanse");
		this.account -= amount;
	}

	@Override
	public double getBalance() {
		return this.account;
	}
	
	protected void endYearUpdate() {
		this.account += this.account*rente;
	}
	
	
	
	
	
}
