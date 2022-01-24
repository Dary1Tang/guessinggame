// Hung Yee Tang (Daryl)

// CS 145

//Lab 1 Guessing Game 

// 16 January 2022

// This program is a simple guessing game with statistics at the end when the user quits playing.

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class GuessingGame {
    // Controls the flow of the program, with the variables at the top showing the
    // total amount of games, guesses, best game guesses and best game which will all be updated below.
    public static void main(String[] args){
        int totalGames = 0; 
        int totalGuess = 0; 
        int bestGameGuess = 999999999; 
        int bestGame = 0;
        Scanner console = new Scanner(System.in);
        intro();
        initiator();

        boolean run = true;
    // program continues to run until the boolean returns false.
        while (run) {
            totalGames++;
            int latestGame = gameplay(console);
            totalGuess += latestGame;
            int latestGuess = latestGame;
            

            if (latestGuess < bestGameGuess) {
                bestGameGuess = latestGuess;
                bestGame++;
            }
            
            run = menu(console);
        }
        statistics(totalGames, totalGuess, bestGame);
    }

    // introduces the progeam to the user.
    public static void intro(){
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();
    }
    
    // Prompts the user to styart the game when the user is ready.
    public static void initiator(){
        System.out.println("Are you ready? Press any key and click ENTER to continue");
        try{
            System.in.read();
        }  
        catch(Exception e){

        } 
    }

    // the part of how the gameplay element flows with a try/catch command to check whether the user enters a number or not.
    public static int gameplay(Scanner console){
        Random r = new Random();
        int randomNum = r.nextInt(101);
        int inputNum = 0;
        int guess = 0;   
        System.out.println("I'm thinking of a number between 1 and 100...");
        

        while (inputNum != randomNum) {
            System.out.print("Your guess? ");
                    inputNum = intChecker(console);
            
            guess++;

                if(inputNum < randomNum) {
                    System.out.println("It's higher");
                } else if (inputNum > randomNum){
                    System.out.println("It's lower");
                } else {
                    System.out.println("You got it right in " + guess + " guesses");
                }  
        }                
        return guess;
    }

    // the menu where it asks for the user if they wanna play the game again, it also checks whether the user has entered
    // a valid command.
    public static boolean menu(Scanner console){
        System.out.println("Do you want to play again?");
        String userInput = stringChecker(console);
        if (userInput.startsWith("y") || userInput.startsWith("Y")) {
            return true;
        } else {
            return false;
        }

    }

    // shows the statistics of the user.
    public static void statistics(int totalGames, int totalGuess,int bestGame) {
        double avgGuess = totalGuess / totalGames;
        System.out.println("Overall results:");
        System.out.println("    total games = " + totalGames);
        System.out.println("    total guesses = " + totalGuess);
        System.out.println("    guesses / game = " + avgGuess);
        System.out.println("    best game = " + bestGame);
        System.out.println("Thanks for playing! (* ^ o ^)");
    }

    // checks whether the user input is a number or not, if it isn't, it would
    // prompt the user to type numbers
    public static int intChecker(Scanner console) {
        try{
            return console.nextInt();
        } catch (InputMismatchException e){
            System.out.print("Please enter a number: ");
            console.next();
            return intChecker(console);
        }
    }

    // checks whether the command entered is a valid command,
    // if not, it would prompt the user a correct command.
    public static String stringChecker(Scanner console) {
        String keyboard = console.next();
        if(keyboard.equalsIgnoreCase("y") || keyboard.equalsIgnoreCase("Yes") || keyboard.equalsIgnoreCase("n") || keyboard.equalsIgnoreCase("No") || keyboard.equalsIgnoreCase("Nope")) {
            return keyboard;
        } else {
            System.out.println("Please enter a valid command");
            return stringChecker(console);
        }
    }
    
    
}