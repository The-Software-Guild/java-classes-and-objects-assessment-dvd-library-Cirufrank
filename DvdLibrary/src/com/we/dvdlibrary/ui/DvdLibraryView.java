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
 * @description This class acts and the view of the DVD Library application 
 * and provides an interface for all methods necessary to display information 
 * to a user
 */

public class DvdLibraryView {
    final private String WELCOME_BANNER = "=== WelCOME TO THE DVD LIBRARY ===",
            MENU_BANNER = "=== MENU ===",
            PRESS_ENTER_TO_CONTINUE = "Press enter to continue...",
            GOODBYE_MESSAGE = "=== Goodbye ===",
            GET_ALL_DVDS_MENU_OP1 = "1: Get all DVDs",
            SEARCH_FOR_DVDS_MENU_OP2 = "2: Search for DVDs by title",
            FIND_EXACT_MATCH_MENU_OP3 = "3: Find exact DVD match by title",
            UPDATE_A_DVD_MENU_OP4 = "4: Update a DVD entry",
            REMOVE_DVD_MENU_OP5 = "5: Remove a DVD",
            EXIT_MENU_OP6 = "6: Exit",
            NO_DVDS_FOUND_MESSAGE = "No DVDs found.",
            DVD_NOT_REMOVED_MESSAGE = "DVD not removed.",
            DVD_NOT_UPDATED_MESSAGE = "DVD not updated.",
            PLEASE_ENTER_CHOICE_MESSAGE = "Please select from the above choices.";
    final private int MIN_VALID_CHOICE = 1, MAX_VALID_CHOICE = 6;
            
    UserIO io;
    
    public DvdLibraryView(UserIO myIO) {
        this.io = myIO;
    }
    
    public void printWelcomeBanner() {
       io.print(WELCOME_BANNER);
    }
    public void printMenuBanner() {
        io.print(MENU_BANNER);
    }
    public void printGoodbyeMessage() {
        io.print(GOODBYE_MESSAGE);
    }
    public void printMenu() {
        io.print(GET_ALL_DVDS_MENU_OP1);
        io.print(SEARCH_FOR_DVDS_MENU_OP2);
        io.print(FIND_EXACT_MATCH_MENU_OP3);
        io.print(UPDATE_A_DVD_MENU_OP4);
        io.print(REMOVE_DVD_MENU_OP5);
        io.print(EXIT_MENU_OP6);
    }
    public int getMenuChoice() {
        int userChoiceNumber = io.readInt(PLEASE_ENTER_CHOICE_MESSAGE, 
                MIN_VALID_CHOICE,
                MAX_VALID_CHOICE);
        io.print("You chose: " + userChoiceNumber);
        return userChoiceNumber;
    }
    public void printNoDvdsFoundMessage() {
        io.print(NO_DVDS_FOUND_MESSAGE);
    }
    public void getNoDvdsRemovedMessage() {
        io.print(DVD_NOT_REMOVED_MESSAGE);
    }
}
