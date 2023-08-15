import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxAttempts = 3;
        int score = 0;

        System.out.println("Welcome to the Number Game");
        System.out.println();

        do{
            int generatedNumber = random.nextInt(100 - 1 + 1) + 1;
            int attempts = 0;

            System.out.println("Select a number between (1-100)"); 
            System.out.println();
            
            System.out.println("You are left with " + maxAttempts + 
            		" attempts to guess the number");

            while(attempts<maxAttempts){
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if(userGuess==generatedNumber){
                    System.out.println("Congratulations you've guessed the "
                    		+ "correct number in " 
                    		+ attempts + " attempts");
                    score++;
                    break;
                    
                }else if(userGuess<generatedNumber){
                    System.out.println("Guessed Too low!");
                    System.out.println();
                    
                }else{
                    System.out.println("Guessed Too high!");
                    System.out.println();
                }
            }

            if(attempts==maxAttempts){
                System.out.println("No attempts left! The correct number was: " 
                		+ generatedNumber);
            }

            System.out.print("Do you want to play again?(y/n): ");
        } 
        while(scanner.next().equalsIgnoreCase("y"));

        System.out.println();
        System.out.println("Game Over! Your final score is: " + score);
        scanner.close();
    }
}