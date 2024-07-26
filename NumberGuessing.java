import java.util.*;
class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1; // Generate a random number between 1 and 100
        int numberOfTries = 0;

        Scanner input = new Scanner(System.in);
        int guess;

        while (true) {
            System.out.println("Guess a number between 1 and 100:");
            guess = input.nextInt();
            numberOfTries++;

            if (guess > numberToGuess) {
                if (guess - numberToGuess > 20) {
                    System.out.println("Your guess is way too high! Try again!");
                } else {
                    System.out.println("Your guess is a bit too high. Try again!");
                }
            } else if (guess < numberToGuess) {
                if (numberToGuess - guess > 20) {
                    System.out.println("Your guess is way too low! Try again!");
                } else {
                    System.out.println("Your guess is a bit too low. Try again!");
                }
            } else {
                System.out.println("Congratulations! You found the number in " + numberOfTries + " tries.");
                break;
            }
        }
    }
}