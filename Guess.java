
// import Scanner
import java.util.*;

public class Guess {

    public static void main(String[] args) {
        boolean playing = false;
        int min = 0, max = 1000, guess;
        String userInput;
        int operationCount = 0;
        
        Scanner console = new Scanner(System.in);
        
        System.out.println("I will try to guess the number you are thinking of in 10 guesses. After my guess, enter either L or H to tell me whether the number you're thinking of is higher or lower, or 0 if my guess is correct.");
        playing = true; // set boolean to true, so the while loop condition is satisfied
        
        do {
        guess = (min + max) / 2;
        System.out.println("My guess is " + guess);
        System.out.println("Is it higher, or lower?");
        
        userInput = console.next(); // ask user to input either l (lower) or h (higher)
        
        /*
        If user enters l (lower), set max to guess - 1 
        If user enters h (higher), set max to guess + 1 
        If user enters 0, exit while loop and show that the program has guessed correctly
        Any other input, the min, max and guess variables are set to their original values
        and the user has to try again from the beginning.
        */
        if (userInput.equals("L") || userInput.equals("l")) {
            max = guess - 1; 
            operationCount++;
        } else if (userInput.equals("H") || userInput.equals("h")) {
            min = guess + 1;
            operationCount++;
        } else if (userInput.equals("0")) {
            System.out.println("Your number is: " + guess);
            System.out.println("It took me " + operationCount + " guesses to guess your number.");
            break;
        } else {
            System.out.println("Incorrect input. Only enter either H, L or 0. Start again.");
            operationCount = 0;
            min = 0;
            guess = 500;
            max = 1000;
        }
        
        // Check if number of guesses exceed 10, otherwise the user is Cheating
        if (operationCount > 10) {
            System.out.println("You are cheating!");
            System.exit(0);
        }
        } while (playing == true);
}
}
