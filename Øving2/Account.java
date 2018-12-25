package encapsulation;

import java.text.DecimalFormat;

public class Account {
	
	private double balance;
	
	private double interestRate;
	
	public Account(double balance, double rate) {
		if (balance >= 0 && rate >= 0) {
			this.balance=balance;
			this.interestRate=rate;
		} else {
			throw new IllegalArgumentException("Kan ikke være negative verdier");
		}
	}
	
	public double getBalance() {
		return balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		if (interestRate > 0) {
			this.interestRate=interestRate;
		} else {
			throw new IllegalArgumentException("Kan ikke være negative verdier");

		}
	}
	
	public void deposit(double amount) {
		if (amount >= 0) {
			this.balance+=amount;
		} else {
			throw new IllegalArgumentException("Kan ikke være negative verdier");

		}
	}
	
	public void withdraw(double amount) {
		if (amount <= balance) {
			this.balance-=amount;
		}else {
			throw new IllegalArgumentException("Kan ikke være negative verdier");
		}
	}
	public void addInterest() {
		/*double interest = (balance*interestRate)/100;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		this.balance += Double.parseDouble(numberFormat.format(interest));*/
		this.balance += (balance*interestRate)/100;
	}
	
	public static void main(String[] args) {
		Account penger = new Account(1000, 5);
		System.out.println(penger.getBalance());
		penger.deposit(5000);
		penger.addInterest();
		System.out.println(penger.getBalance());
		penger.withdraw(6000);
		System.out.println(penger.getBalance());

	}
	
}
