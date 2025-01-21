import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game variables
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            // Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("\nI have selected a number between 1 and 100. Can you guess it?");

            // Game loop
            while (guess != targetNumber) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }
            }

            // Ask if the user wants to play again
            System.out.print("Would you like to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }
}
