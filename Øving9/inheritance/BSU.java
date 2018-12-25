package inheritance;

public class BSU extends SavingsAccount {
	
	protected double maxDeposit;
	protected double årligDeposit;

	
	public BSU(double rente, double deposit) {
		super(rente);
		this.maxDeposit = deposit;
		årligDeposit = 0;
	}
	
	@Override
	public void deposit(double amount) {
		if (årligDeposit + amount > maxDeposit) throw new IllegalStateException("Cannot deposit more than the limit of per year.");

		super.deposit(amount);
		årligDeposit += amount;
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount > årligDeposit) throw new IllegalStateException("Cannot deposit more than the limit of per year.");

		super.withdraw(amount);
		årligDeposit -= amount;
	}
	
	
	public double getTaxReduction() {
		return årligDeposit * 0.20;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		årligDeposit = 0;
	}

}
