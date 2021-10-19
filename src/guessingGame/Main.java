package guessingGame;

//Number guessing game that allows user to guess a random number that the program has generated, through a GUI.

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int computerNumber = (int) (Math.random() * 100 + 1); // Number to be guessed, generated with Math.random()
																// method
		int userAnswer = 0;
		// System.out.println("The correct guess should be " + computerNumber); //This
		// statement should give us the correct answer.

		int count = 1; // Counting tries

		// Creating GUI for the game display

		while (userAnswer != computerNumber) {
			String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 and 100", "Guessing Game", 3);
			userAnswer = Integer.parseInt(response);
			JOptionPane.showMessageDialog(null, "" + determineGuess(userAnswer, computerNumber, count));
			count++;
		}
	}

	// Function with different outputs, according to player's guess, that also
	// counts player's tries.

	public static String determineGuess(int userAnswer, int computerNumber, int count) {
		if (userAnswer <= 0 || userAnswer > 100) {
			return "Invalid Answer";
		} else if (userAnswer == computerNumber) {
			return "Correct!\nTotal Guesses: " + count;
		} else if (userAnswer > computerNumber) {
			return "Your guess is too high! Try again.\nTry Number: " + count;
		} else if (userAnswer < computerNumber) {
			return "Your guess is too low... Try again.\nTry Number: " + count;
		} else {
			return "Your guess is incorrect\nTry Number: " + count;
		}
	}
}