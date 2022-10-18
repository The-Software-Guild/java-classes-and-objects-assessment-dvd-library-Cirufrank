/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.app;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Exercise: Refactor into Objects
 * 
 * @description This is a program that allows users to play Rock, Paper, Scissors.
 * If the user inputs invalid input the program will continue to prompt them until valid input is entered
 * The program asks them for the number of rounds they'd like to play and this can be between 10 and 1 inclusive
 * Then the program keeps track of the current rounds and displays the number of computer wins and user wins
 * The program continues until the total number of rounds have been played
 */
public class App {
    public static void main(String[] args) {
        RockPaperScissors rockPaperScissorsGame = new RockPaperScissors();
        rockPaperScissorsGame.welcomeUser();
        rockPaperScissorsGame.getUserRoundTotalInput();
        if (rockPaperScissorsGame.getRoundsToPlay() < rockPaperScissorsGame.getMinRounds() || rockPaperScissorsGame.getRoundsToPlay() > rockPaperScissorsGame.getMaxRounds()) {
            Helper.print(rockPaperScissorsGame.getChoiceOutOfRangeMessage());
            return;
        }
        //Continue to play rock paper scissors with user until there are no rounds left
        while (rockPaperScissorsGame.getRoundsToPlay() > 0) {
            rockPaperScissorsGame.lowerRoundTotal();
            rockPaperScissorsGame.collectUserChoiceInput();
            rockPaperScissorsGame.makeComputerChoice();
            rockPaperScissorsGame.determineWinner();
            rockPaperScissorsGame.displayChoices();
            rockPaperScissorsGame.updateWins();
            rockPaperScissorsGame.displayWinner();
            rockPaperScissorsGame.displayWins();
        }
        Helper.print(rockPaperScissorsGame.getThankYouForPlayingMessage());
         
    }

}
