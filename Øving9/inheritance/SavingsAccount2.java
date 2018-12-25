package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	
	protected int withdrawals;
	protected double fee;
	
	public SavingsAccount2(int antall, double gebyr) {
		super();
		this.withdrawals = antall;
		this.fee = gebyr;
	}
	
	@Override
	protected void internalWithdraw(double amount) {
		if (amount > account) throw new IllegalStateException("");
		if(withdrawals > 0) {
			account -= amount;
			withdrawals--;
		}else if(account > amount + fee){
			account -= amount + fee;
		}else {
			throw new IllegalStateException("");
		}
	}
	
	
	
}
