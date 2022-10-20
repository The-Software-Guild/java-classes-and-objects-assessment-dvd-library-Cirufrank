/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.we.dvdlibrary.ui;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This interface defines the methods to be implemented by this DVD
 * Library application's User interface
 */
public interface UserIO {
    /**
     * Displays the specified message to the user
     *
     * @param message message to be displayed to user
     * @return void
     */
    void print(String message);
    /**
     * Prompts user for a string and then returns their trimmed
     *
     * @param message message to be displayed to user when prompting
     * them for input
     * @return string input from user
     */
    String readString(String message);
    /**
     * Prompts user for an integer and continues to do so until
     * user input can be parsed to an integer without error
     *
     * @param message message to be displayed to user when prompting
     * them for input
     * @return parsed integer from user input
     */
    int readInt(String message);
    /**
     * Prompts user for an integer and continues to do so until
     * user input can be parsed to an integer without error that is within
     * the specified range
     *
     * @param message message to be displayed to user when prompting
     * them for input
     * @return parsed integer from user input
     */
    
    int readInt(String message, int min, int max);
    /**
     * Prompts user for a yes or no answer and continues to do so until 
     * their answer is yes or no (case insensitive)
     *
     * @param message message to be displayed to user when prompting
     * them for input
     * @return string character sequence of "yes" or "no"
     */
    String readYesOrNo(String message);
}
