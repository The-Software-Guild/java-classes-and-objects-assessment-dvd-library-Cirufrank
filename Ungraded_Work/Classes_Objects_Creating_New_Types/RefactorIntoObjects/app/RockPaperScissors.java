/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: Basic Programming Concepts: Rock, Paper, Scissors
 * 
 * @description This is the class from which Rock, Paper, Scissors game objects are instantiate from
 * Implemented below are all the needed methods for users to create anr play a game of Rock, Paper, Scissors
 * through the class' defined interface (i.e. getters, setters, and methods)
 */

public class RockPaperScissors {
    private String welcomeMessage = "/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\"
                + "_/\\_/\\_/\\\n" + "          Welcome to Rock, Paper, Scissors!\n" +
                "\\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n", 
                thankYouForPlayingMessage =  "/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_"
                + "/\\_/\\_/\\_/\\\n" + "                 Thanks for playing!  \n" +
                "\\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n";
                
    final private static String CHOICE_OUT_OF_RANGE_MESSAGE = "Your choice was "
                + "out of the range specified. Goodbye.", TOTAL_ROUNDS_PROMPT_MESSAGE = "How many rounds between 1 "
                + "and 10 inclusive would you "
                + "like to play?", COMPUTER_NAME = "The Computer", USER_NAME = "You", TIE_NAME = "Tie!", 
                SCISSORS = "scissors", ROCK = "rock", PAPER = "paper";
    final private static int MAX_ROUNDS = 10, MIN_ROUNDS = 1, ONE_WIN = 1, ONE_ROUND = 1;
    final private static String[] VALID_CHOICES = {"rock", "paper", "scissors"};
    private String userChoice, computerChoice, winner;
    private int roundsToPlay, computerWins = 0, userWins = 0, ties = 0;
    private boolean validChoice = false;
    
    RockPaperScissors() {
    }
    public String getChoiceOutOfRangeMessage() {
        return CHOICE_OUT_OF_RANGE_MESSAGE;
    }
    public String getWelcomeMessage() {
        return welcomeMessage;
    }
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
    public String getThankYouForPlayingMessage() {
        return thankYouForPlayingMessage;
    }

    public void setThankYouForPlayingMessage(String thankYouForPlayingMessage) {
        this.thankYouForPlayingMessage = thankYouForPlayingMessage;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public String getWinner() {
        return winner;
    }

    public int getRoundsToPlay() {
        return roundsToPlay;
    }
    
    public int getComputerWins() {
        return computerWins;
    }

    public int getUserWins() {
        return userWins;
    }

    public int getTies() {
        return ties;
    }

    public boolean getIsValidChoice() {
        return validChoice;
    }

    public String getOutOfRangeMessage() {
        return CHOICE_OUT_OF_RANGE_MESSAGE;
    }

    public String getComputerName() {
        return COMPUTER_NAME;
    }

    public String getUserName() {
        return USER_NAME;
    }

    public String getTieName() {
        return TIE_NAME;
    }

    public String getScissors() {
        return SCISSORS;
    }

    public String getRock() {
        return ROCK;
    }

    public String getPaper() {
        return PAPER;
    }

    public int getMaxRounds() {
        return MAX_ROUNDS;
    }

    public int getMinRounds() {
        return MIN_ROUNDS;
    }

    public int getOneWin() {
        return ONE_WIN;
    }

    public int getOneRound() {
        return ONE_ROUND;
    }

    public String[] getValidChoices() {
        return VALID_CHOICES;
    }

    public String getTotalRoundsPromptMessage() {
        return TOTAL_ROUNDS_PROMPT_MESSAGE;
    }
    public void welcomeUser() {
        Helper.print(welcomeMessage);
    }
    public void getUserRoundTotalInput() {
        String stringRoundsToPlay = Helper.getInput(TOTAL_ROUNDS_PROMPT_MESSAGE);
        //Continue to get rounds to play integer (as a string) until input can be parsed to an integer without error
        while(validateIntegerInput(stringRoundsToPlay) != true) {
            stringRoundsToPlay = Helper.getInput(TOTAL_ROUNDS_PROMPT_MESSAGE);
        }
        roundsToPlay = Integer.parseInt(stringRoundsToPlay);
    }
    public void lowerRoundTotal() {
        roundsToPlay -= ONE_ROUND;
    }
    public static boolean validateIntegerInput(String input) {
        //Try to parse input to integer
        //If an exception is thrown return false, and if not, return true
        boolean isValidInteger = false;
        try {
            Integer.valueOf(input);
            isValidInteger = true;
        } catch(NumberFormatException error) {
            Helper.print(Helper.getInvalidInputMessage());
        }
        
        return isValidInteger;
    }
    public static boolean validateChoiceInput(String input) {
        //Check to see if a choice is included within the valid choices, and return whether or not it is
        boolean isValidChoice = Arrays.stream(VALID_CHOICES).anyMatch(choice -> choice.equals(input));
        if (isValidChoice == false) Helper.print(Helper.getInvalidInputMessage());
        return isValidChoice;
        
    }
    public void collectUserChoiceInput() {
        //Continue to ask for choice until a valid choice is entered, then return choice
        final String ROCK_PAPER_SCISSORS_INPUT_MESSAGE = "Rock, Paper, or Scissors?";
        userChoice = Helper.getInput(ROCK_PAPER_SCISSORS_INPUT_MESSAGE);
        while(validateChoiceInput(userChoice) != true) {
            userChoice = Helper.getInput(ROCK_PAPER_SCISSORS_INPUT_MESSAGE);
        }
    }
    public void makeComputerChoice() {
        final int choiceIndex = Helper.generateRandomIndex(VALID_CHOICES);
        computerChoice = VALID_CHOICES[choiceIndex];
    }
    public void determineWinner() {
        if (userChoice.equals(computerChoice)) winner = TIE_NAME;
        //Check to see if the user won
        else if ((userChoice.equals(SCISSORS) && computerChoice.equals(PAPER)) || 
                (userChoice.equals(PAPER) && computerChoice.equals(ROCK)) || (
                userChoice.equals(ROCK) && computerChoice.equals(SCISSORS))) winner = USER_NAME;
        else winner = COMPUTER_NAME;
    }
    public void displayWinner() {
        final String ARE_THE_WINNER_TEXT = " are the winner!";
        final String IS_THE_WINNER_TEXT = " is the winner!";
        if (winner ==  USER_NAME) {
            Helper.print(winner + ARE_THE_WINNER_TEXT);
        } else if (winner == COMPUTER_NAME) {
            Helper.print(winner + IS_THE_WINNER_TEXT);
        } else {
            Helper.print(TIE_NAME);
        }
    }
    public void displayWins() {
        Helper.print("Your wins: " + userWins);
        Helper.print("The computer's wins: " + computerWins);
        Helper.print("Ties: " + ties);
        if (roundsToPlay >= 0 ) Helper.print("Rounds Remaining: " + roundsToPlay);
    }
    public void updateWins() {
        switch (winner) {
                case USER_NAME: 
                    userWins += ONE_WIN;
                    break;
                case COMPUTER_NAME:
                    computerWins += ONE_WIN;
                    break;
                case TIE_NAME:
                    ties += ONE_WIN;
                    break;
            }
    }
    public void displayChoices() {
        Helper.print(USER_NAME + " chose: " + userChoice);
        Helper.print(COMPUTER_NAME + " chose: " + computerChoice);
    }
    
}
