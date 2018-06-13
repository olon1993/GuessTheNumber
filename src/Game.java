import java.util.Scanner;

public class Game {

	//Game Variables
	private int low = 1,
				high = 1000,
				mid = low + (high - low ) / 2,
				guesses = 1;
	
	private Scanner keyboard;
	
	public Game() {
		init();
		
		while(true) {
			System.out.println("Pick a number between " + low + " and " + high + ".");
			System.out.print("Ready? ");
			String response = keyboard.nextLine();
			
			if(response.trim().toUpperCase().contentEquals("YES") || 
			   response.trim().toUpperCase().contentEquals("Y")) {
				break;
			}
		}
		
		while(true) {
			System.out.println("Is this your number? " + mid);
			String response = keyboard.nextLine();
			
			if(response.trim().toUpperCase().contentEquals("YES") || 
			   response.trim().toUpperCase().contentEquals("Y")) {
				System.out.println("I guessed your number in " + guesses + " guesses!");
				break;
			} else {
				System.out.println("Is your number higher or lower? ");
				response = keyboard.nextLine();
				
				if(response.trim().toUpperCase().contentEquals("HIGHER") || 
				   response.trim().toUpperCase().contentEquals("H")) {
					low = mid;
					mid = low + (high - low) / 2;
				} else {
					high = mid;
					mid = low + (high - low) / 2;
				}
			}
			
			guesses++;
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
	public void init() {
		keyboard = new Scanner(System.in);
	}
	
}
