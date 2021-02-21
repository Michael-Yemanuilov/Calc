package calc;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

		System.out.println("Welcome to Calculator");
		System.out.println("To quit enter \"q\"");
		System.out.println("Please enter your data and press \"Enter\"");

		// Create the scanner
		try(Scanner scanner = new Scanner(System.in)){
			
			while(scanner.hasNextLine()) {	

				// Read user input
				String userInputString = scanner.nextLine();
				
				if (userInputString.equals("q")) {
					System.out.println("Quit");
					System.exit(0);
				}
				
				String[] userInput = userInputString.trim().split(" ");
				
				// Validate user input
				if (Execution.validateInput(userInput)) {
					// Compute and output to the console
					System.out.println(Execution.compute());
				} else {
					// Throw exception if input invalid
					throw new RuntimeException("Invalid operation!");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
