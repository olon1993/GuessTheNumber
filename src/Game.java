import java.util.Scanner;

public class Game {

	//Game Variables
	private int low = 1,
				high = 1000,
				mid = low + (high - low) / 2,
				guesses = 0;
	
	private Scanner keyboard;
	
	public Game() {
		init();
		gameLoop();
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
	public void init() {
		keyboard = new Scanner(System.in);
		
		while(true) {
			//Allow the player to pick a number
			System.out.println("Pick a number between " + low + " and " + high + ".");
			System.out.print("Ready? ");
			String response = keyboard.nextLine();
			
			if(response.trim().toUpperCase().contentEquals("YES") || 
			   response.trim().toUpperCase().contentEquals("Y")) {
				break;
			} else if(response.trim().toUpperCase().contentEquals("NO") || 
					  response.trim().toUpperCase().contentEquals("N")) {
				System.out.println("Take your time. When you have decided upon a number "
						+ "type \"Yes\" or \"Y\".");
			} else {
				System.out.println("Type \"Yes\" or \"Y\" when you have decided upon a "
						+ "number. If you need more time type \"No\" or \"N\".");
			}
		}
	}
	
	public void gameLoop() {
		// The computer uses an algorithm similar to binary search to narrow down 
		// the possibilities before ultimately guessing the correct number.
		while(true) {
			System.out.println("Is your number " + mid + "?");
			String response = keyboard.nextLine();
			
			// The game is over, the computer guessed the correct number
			if(response.trim().toUpperCase().contentEquals("YES") || 
			   response.trim().toUpperCase().contentEquals("Y")) {
				guesses++;
				System.out.println("I guessed your number in " + guesses + " guesses!");
				break;
				
			// The computer guessed wrong and must guess again
			} else if(response.trim().toUpperCase().contentEquals("NO") || 
					  response.trim().toUpperCase().contentEquals("N")){
				guesses++;
				
				while(true) {
					System.out.println("Is your number higher or lower than " + mid + "? ");
					response = keyboard.nextLine();
				
					if(response.trim().toUpperCase().contentEquals("HIGHER") || 
					   response.trim().toUpperCase().contentEquals("H")) {
						newGuess(mid, high);
						break;
					} else if(response.trim().toUpperCase().contentEquals("LOWER") || 
							  response.trim().toUpperCase().contentEquals("L")){
						newGuess(low, mid);
						break;
						
					// Invalid input, the player is reminded of the rules of the game.
					} else {
						System.out.println("I'm sorry, I didn't quite undterstand that. If your "
								+ "number is higher than " + mid + " type \"Higher\" or \"H\". "
								+ "If your number is lower than " + mid + " type \"Lower\" or "
								+ "\"L\".");
					}
				}
			
			// Invalid input, the player is reminded of the rules of the game.
			} else {
				System.out.println("I'm sorry, I didn't quite undterstand that. If I "
						+ "guessed your number correctly type \"Yes\" or \"Y\". If I "
						+ "guessed your number incorrectly type \"No\" or \"N\".");
			}
		}
	}
	
	public void newGuess(int low, int high) {
		this.low = low;
		this.high = high;
		this.mid = low + (high - low) / 2;
	}
	
}
