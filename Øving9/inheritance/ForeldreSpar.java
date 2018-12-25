package inheritance;

public class ForeldreSpar extends SavingsAccount{
	
	protected int lovligeUttak;
	protected int antallUttak;

	public ForeldreSpar(double rente, int lovligeUttak) {
		super(rente);
		this.lovligeUttak = lovligeUttak;
		antallUttak = 0;
	}
	
	@Override
	public void withdraw(double amount) {
		if (antallUttak >= lovligeUttak) throw new IllegalStateException("");
		super.withdraw(amount);
		antallUttak++;
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
	}
	
	
	public int getRemainingWithdrawals() {
		return lovligeUttak - antallUttak;
	}
	
	@Override
	protected void endYearUpdate() {
		super.endYearUpdate();
		lovligeUttak = 0;
	}
	
	
}
