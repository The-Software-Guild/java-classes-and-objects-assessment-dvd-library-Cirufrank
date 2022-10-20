/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary.ui;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This is a console implementation of the user interface
 * and provides helper methods for the view to use while getting user input
 */

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    final public String INVALID_INTEGER_MESSAGE = "Invalid input. Please enter a valid integer.";
    
    public void print(String message) {
        System.out.println(message);
    }
    public String readString(String message) {
        Scanner scanner = new Scanner(System.in);
        print(message);
        String stringInput = scanner.nextLine().trim().intern();
        return stringInput;
    }
    public int readInt(String message) {
        boolean invalidInput = true;
        String stringInt;
        int integerInput = 0;
        do {
          stringInt = readString(message);
          try {
              integerInput = Integer.parseInt(stringInt);
              invalidInput = false;
          } catch(NumberFormatException error) {
              print(INVALID_INTEGER_MESSAGE);
          }
        } while(invalidInput == true);
        
        return integerInput;
    }
    public int readInt(String message, int min, int max) {
        boolean invalidInput;
        String stringInt;
        int integerInput = 0;
        do {
            invalidInput = true;
            stringInt = readString(message);
            try {
                integerInput = Integer.parseInt(stringInt);
                invalidInput = false;
                if (integerInput < min || integerInput > max) print("Invalid input. "
                        + "Please enter a valid integer "
                        + "between " + min + " and " + max + ".");
            } catch(NumberFormatException error) {
                print(INVALID_INTEGER_MESSAGE);
            }
        } while(invalidInput == true || integerInput < min 
                || integerInput > max);
        
        return integerInput;
    }
}
