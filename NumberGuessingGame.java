import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 10;
        int attempts = 0;
        int remainingAttempts;
        System.out.println("  ");
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("  ");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Try to guess it within " + maxAttempts + " attempts.");
        System.out.println("**********************************************************************");

        while (attempts < maxAttempts) {
            System.out.println("  ");
            System.out.println("What do you think?");
            int userGuess = sc.nextInt();
            attempts++;
            remainingAttempts = maxAttempts - attempts;

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations, You guessed it right!");
                System.out.println("You guessed it "+attempts+" Attempts");
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
                System.out.println("Remaining Attempts: " + remainingAttempts);
            } else {
                System.out.println("Too high! Try again.");
                System.out.println("Remaining Attempts: " + remainingAttempts);

            }

        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
        }

        sc.close();
    }
}
