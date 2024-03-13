import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange, maxRange, attemptsLimit, difficultyLevel;
        int score = 0;
        int highScore = 0;
        boolean firstRound = true;

        System.out.println("Welcome to Guess the Number Game!");

        do {
            
            System.out.println("\nChoose difficulty level:");
            System.out.println("1. Easy (1-50, 8 attempts)");
            System.out.println("2. Medium (1-100, 6 attempts)");
            System.out.println("3. Hard (1-200, 4 attempts)");
            System.out.print("Enter your choice: ");
            difficultyLevel = scanner.nextInt();

            switch (difficultyLevel) {
                case 1:
                    minRange = 1;
                    maxRange = 50;
                    attemptsLimit = 8;
                    break;
                case 2:
                    minRange = 1;
                    maxRange = 100;
                    attemptsLimit = 6;
                    break;
                case 3:
                    minRange = 1;
                    maxRange = 200;
                    attemptsLimit = 4;
                    break;
                default:
                    System.out.println("Invalid choice. Setting to Medium difficulty.");
                    minRange = 1;
                    maxRange = 100;
                    attemptsLimit = 6;
            }

            if (!firstRound) {
                System.out.println("\nHigh Score: " + highScore);
            }

            int attempts = 0;
            boolean guessedCorrectly = false;
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ". Guess it!");

            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    score += attemptsLimit - attempts + 1; 
                    if (score > highScore) {
                        highScore = score;
                    }
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
            firstRound = false;
        } while (true);

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}
