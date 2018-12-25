package encapsulation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AccountController {
	@FXML Label balance;
	@FXML TextField deposit;
	@FXML TextField withdraw;
	@FXML TextField rentefot;
	@FXML Label interestRate;
	
	
	Account ac = new Account(0, 0);
	
	/*@FXML
	public void startAccount() {
		balance.setText(Double.toString(ac.getBalance()));
		interestRate.setText("Rente: " + Double.toString(ac.getInterestRate()));
	}*/
	 
	@FXML
	public void handleDeposit(){
		String amount = deposit.getText();
		ac.deposit(Double.parseDouble(amount));
		balance.setText(Double.toString(ac.getBalance()));
	}
	
	@FXML
	public void handleWithdraw() {
		String amount = withdraw.getText();
		ac.withdraw(Double.parseDouble(amount));
		balance.setText(Double.toString(ac.getBalance()));
	}
	
	@FXML
	public void handleInterest() {
		ac.addInterest();
		balance.setText(Double.toString(ac.getBalance()));
	}
	
	@FXML
	public void setRate() {
		String amount = rentefot.getText();
		ac.setInterestRate(Double.parseDouble(amount));
		interestRate.setText("Rente: " + Double.toString(ac.getInterestRate()));
	}
	
	
}
