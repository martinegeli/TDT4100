package inheritance;

public class CreditAccount extends AbstractAccount {

	private double creditLine;
	
	public CreditAccount(double creditLine) {
		super();
		this.creditLine = creditLine;
	}
	
	public double getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(double creditLine) {
		if (creditLine < 0) throw new IllegalArgumentException("");
		if (account < -creditLine && account < 0) throw new IllegalStateException("");
		this.creditLine = creditLine;
	}

	@Override
	protected void internalWithdraw(double amount) {
		if (account - amount >= - creditLine) account -= amount;
		else throw new IllegalArgumentException("");
	}
	
	
	
	
}
