/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.app;

/**
 *
 * @author ciruf
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
