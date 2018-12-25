package objectstructures;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TicTacToeController {
	
	
	@FXML
	TicTacToe game = new TicTacToe();
	
	@FXML
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
	
	@FXML
	TextField textField;
	
	
	
	@FXML
	public void initialize() {
		game = new TicTacToe();
	}
	
	public void update() {
		if (!(game.isFinished())){
			textField.setText("Nå er det spiller " + Character.toString(game.getCurrentPlayer()) + " sin tur.");
		
		}
		else {
			if (game.hasWinner()) {
				textField.setText("Spillet er ferdig og spiller " + Character.toString(game.isWinner('X') ? 'X': 'O') + " vant");
				
			} else {
				textField.setText("Spillet er ferdig og ingen vant :(");
			}
		}
		System.out.println(game.toString());
		System.out.println(game.isWinner('X') ? 'X': 'O');
		System.out.println(game.hasWinner());
		System.out.println(game.toString2());

	}
	
	public void handleButton(ActionEvent event) {
		if (!game.isFinished()) {
			if (event.getSource() == b1) {
				game.play(0,0);
				b1.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b2) {
				game.play(0,1);
				b2.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b3) {
				game.play(0,2);
				b3.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b4) {
				game.play(1,0);
				b4.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b5) {
				game.play(1,1);
				b5.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b6) {
				game.play(1, 2);
				b6.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b7) {
				game.play(2,0);
				b7.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b8) {
				game.play(2,1);
				b8.setText(Character.toString(game.getNextPlayer()));
			}
			if (event.getSource() == b9) {
				game.play(2,2);
				b9.setText(Character.toString(game.getNextPlayer()));
			}
			update();
		}
	}
	
	
	
	
}
