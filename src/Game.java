import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

public class Game extends Application{

	// Game Options
	private final String GAMEOVER = "I win! I guessed your number in ";
	private final int HEIGHT = 120;
	private final int WIDTH = 300;
	private final int newLow = 1,
					  newHigh = 1000;
	
	// Game Variables
	private int low;
	private int high;
	private int	mid,
				guesses;
	
	// Scene Variables
	private TextArea gameText;
	private Text score;
	private Button yesButton,
				   noButton,
				   higherButton,
				   lowerButton,
				   newGameButton;
	
	public void start(Stage s) throws Exception {
		sceneInit(s);
		gameInit();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void sceneInit(Stage stage) {
		stage = new Stage();
		stage.setTitle("Number Guess");
		
		gameText = new TextArea();
		gameText.setMinSize(150, 75);
		gameText.setWrapText(true);
		gameText.setEditable(false);
		
		score = new Text();
		
		newGameButton = new Button("New Game");
		newGameButton.setOnAction(e -> { gameInit(); } );
		
		yesButton = new Button("Yes");
		yesButton.setOnAction(e -> { gameOver(); } );
		
		noButton = new Button("No");
		noButton.setOnAction(e -> { incorrectGuess(); } );
		
		higherButton = new Button("Higher");
		higherButton.setOnAction(e -> { newGuess(mid, high); } );
		
		lowerButton = new Button("Lower");
		lowerButton.setOnAction(e -> { newGuess(low, mid); } );
		
		yesButton.setMinSize(75, 30);
		noButton.setMinSize(75, 30);
		higherButton.setMinSize(75, 30);
		lowerButton.setMinSize(75, 30);
		newGameButton.setMinSize(150, 30);
		
		HBox root = new HBox();
		VBox controlBox = new VBox();
		HBox yesnoBox = new HBox();
		HBox highlowBox = new HBox();
		
		yesnoBox.getChildren().addAll(yesButton, noButton);
		highlowBox.getChildren().addAll(higherButton, lowerButton);
		controlBox.getChildren().addAll(score, yesnoBox, highlowBox, newGameButton);
		root.getChildren().addAll(gameText, controlBox);
		
		yesnoBox.setAlignment(Pos.CENTER);
		highlowBox.setAlignment(Pos.CENTER);
		controlBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gameInit() {
		low = newLow;
		high = newHigh;
		mid = low + (high - low) / 2;
		guesses = 1;
		score.setText("Score: 0");
		yesButton.setDisable(false);
		noButton.setDisable(false);
		higherButton.setDisable(true);
		lowerButton.setDisable(true);
		gameText.setText("Pick a number between " + low + " and " + high + ". "
					   + "Is your number " + mid + "?");
	}
	
	public void gameOver() {
		yesButton.setDisable(true);
		noButton.setDisable(true);
		higherButton.setDisable(true);
		lowerButton.setDisable(true);
		gameText.setText(GAMEOVER + guesses + " guesses!");
	}
	
	public void incorrectGuess() {
		score.setText("Score: " + guesses);
		gameText.setText("Is your number higher or lower than " + mid + "? ");
		yesButton.setDisable(true);
		noButton.setDisable(true);
		higherButton.setDisable(false);
		lowerButton.setDisable(false);
	}
	
	public void newGuess(int low, int high) {
		this.low = low;
		this.high = high;
		this.mid = low + (high - low) / 2;
		guesses++;
		gameText.setText("Is your number " + mid + "?");
		yesButton.setDisable(false);
		noButton.setDisable(false);
		higherButton.setDisable(true);
		lowerButton.setDisable(true);
	}
	
}
