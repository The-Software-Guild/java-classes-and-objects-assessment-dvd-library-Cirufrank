/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: Basic Programming Concepts: Rock, Paper, Scissors
 * 
 * @description This is a class of static Helper methods for those implementing the
 * App to use in order to help keep code DRY
 */

public class Helper {
    final private static String INVALID_INPUT_MESSAGE = "Invalid input";
    public static String getInvalidInputMessage() {
        return INVALID_INPUT_MESSAGE;
    }
    public static void print(String message) {
        System.out.println(message + "\n");
    }
    public static String getInput(String message) {
        final Scanner scanner = new Scanner(System.in);
        print(message);
        final String input = scanner.nextLine().trim().toLowerCase();
        return input;
        
    }
    public static int generateRandomIndex(String[] array) {
        Random randomGenerator = new Random();
        final int randomIndex = randomGenerator.nextInt(array.length);
        return randomIndex;
        
    }
}
