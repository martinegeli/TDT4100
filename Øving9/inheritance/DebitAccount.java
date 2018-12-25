package inheritance;

public class DebitAccount extends AbstractAccount {

	
	@Override
	protected void internalWithdraw(double amount) {
		if (amount > getBalance()) throw new IllegalStateException("");
		super.account -= amount;
	}
	
	
}
