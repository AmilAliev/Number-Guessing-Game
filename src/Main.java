import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 5 chances to guess the correct number.\n");
        System.out.println("Please set the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int difficulty = scanner.nextInt();

        int maxAttempts;
        if (difficulty == 1) {
            System.out.println("Great! You have selected the Easy difficulty level.");
            maxAttempts = 10;
        } else if (difficulty == 2) {
            System.out.println("Great! You have selected the Medium difficulty level.");
            maxAttempts = 5;
        } else if (difficulty == 3) {
            System.out.println("Great! You have selected the Hard difficulty level.");
            maxAttempts = 3;
        } else {
            System.out.println("Invalid choice! Defaulting to Medium difficulty.");
            maxAttempts = 5;
        }

        System.out.println("Let's start the game!\n");

        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int attempts = 0;
        boolean gameOver = false;

        long startTime = System.currentTimeMillis();
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == number) {
                long endTime = System.currentTimeMillis();
                double timeTaken = (endTime - startTime) / 1000.0;

                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                System.out.printf("Time taken: %.2f seconds.%n", timeTaken);
                gameOver = true;
                break;
            } else if (userGuess < number) {
                System.out.println("Incorrect! The number is greater than " + userGuess + ".");
            } else {
                System.out.println("Incorrect! The number is less than " + userGuess + ".");
            }

            System.out.println();
        }

        if (!gameOver) {
            long endTime = System.currentTimeMillis();
            double timeTaken = (endTime - startTime) / 1000.0;
            System.out.println("Sorry, you ran out of chances! The correct number was " + number + ".");
            System.out.printf("Time taken: %.2f seconds.%n", timeTaken);
        }

        scanner.close();
    }
}