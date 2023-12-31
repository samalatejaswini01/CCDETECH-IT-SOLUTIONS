import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int attempts = 0;
        boolean hasGuessed = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println(
                "I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        while (!hasGuessed) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            if (userGuess == numberToGuess) {
                hasGuessed = true;
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts
                        + " attempts.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        scanner.close();
    }
}
