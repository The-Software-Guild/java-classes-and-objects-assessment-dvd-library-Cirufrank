/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary.ui;

import com.we.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.List;

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
            ADD_A_NEW_DVD_MENU_OP2 = "2: Add a new DVD",
            SEARCH_FOR_DVDS_MENU_OP3 = "3: Search for DVDs by title",
            FIND_EXACT_MATCH_MENU_OP4 = "4: Find exact DVD match by title",
            UPDATE_A_DVD_MENU_OP5 = "5: Update a DVD entry",
            REMOVE_DVD_MENU_OP6 = "6: Remove a DVD",
            EXIT_MENU_OP7 = "7: Exit",
            NO_DVDS_FOUND_MESSAGE = "No DVDs found.",
            NO_EXACT_MATCH_MESSAGE = "No exact match found.",
            DVD_NOT_REMOVED_MESSAGE = "DVD not removed.",
            DVD_NOT_UPDATED_MESSAGE = "DVD not updated.",
            PLEASE_ENTER_CHOICE_MESSAGE = "Please select from the above choices.",
            ADD_DVD_SUCCESS_MESSAGE = "=== Successfully added DVD ===",
            UPDATE_DVD_SUCCESS_MESSAGE = "=== Successfully updated the DVD ===",
            REMOVE_DVD_SUCCESS_MESSAGE = "=== Successfully removed the DVD ===";
    final private int MIN_VALID_CHOICE = 1, MAX_VALID_CHOICE = 7;
            
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
    public void printAddDvdSuccessMessage() {
        io.print(ADD_DVD_SUCCESS_MESSAGE);
    }
    public void printMenu() {
        io.print(GET_ALL_DVDS_MENU_OP1);
        io.print(ADD_A_NEW_DVD_MENU_OP2);
        io.print(SEARCH_FOR_DVDS_MENU_OP3);
        io.print(FIND_EXACT_MATCH_MENU_OP4);
        io.print(UPDATE_A_DVD_MENU_OP5);
        io.print(REMOVE_DVD_MENU_OP6);
        io.print(EXIT_MENU_OP7);
    }
    public int getMenuChoice() {
        int userChoiceNumber = io.readInt(PLEASE_ENTER_CHOICE_MESSAGE, 
                MIN_VALID_CHOICE,
                MAX_VALID_CHOICE);
        displayMenuChoice(userChoiceNumber);
        return userChoiceNumber;
    }
    public String getDvdTitle() {
        String dvdTitle = io.readString("Please enter the title "
                + "of the DVD");
        return dvdTitle;
    }
    public void displayMenuChoice(int menuChoice) {
        io.print("You chose: " + menuChoice);
    }
    public void printNoDvdsFoundMessage() {
        io.print(NO_DVDS_FOUND_MESSAGE);
    }
    public void printNoExactMatchFoundMessage() {
        io.print(NO_EXACT_MATCH_MESSAGE);
    }
    public void printUpdateDvdSucceessMessage() {
        io.print(UPDATE_DVD_SUCCESS_MESSAGE);
    }
    public void printRemovedDvdSuccessMessage() {
        io.print(REMOVE_DVD_SUCCESS_MESSAGE);
    }
    public void readAndPrintPressEnterToContineMessage() {
        io.readString(PRESS_ENTER_TO_CONTINUE);
    }
    public void getNoDvdsRemovedMessage() {
        io.print(DVD_NOT_REMOVED_MESSAGE);
    }
    public Dvd getNewDvdInfo() {
        final Dvd newDvd = new Dvd();
        String dvdTitle = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter DVD release date");
        String mpaaRating = io.readString("Please enter MPAA rating");
        String directorsName = io.readString("Please enter director's name");
        String studio = io.readString("Please enter studio");
        String notes = io.readString("Please enter your rating and/or notes for the DVD");
        newDvd.setDvdTitle(dvdTitle);
        newDvd.setReleaseDate(releaseDate);
        newDvd.setMpaaRating(mpaaRating);
        newDvd.setDirectorsName(directorsName);
        newDvd.setStudio(studio);
        newDvd.setUserNotes(notes);
        return newDvd;
    } 
    public Dvd getDvdUpdateFields(Dvd dvd) {
        boolean updateTheReleaseDate = io.readYesOrNo("Would you like to update"
                + " the DVD's release date?") == "yes";
        if (updateTheReleaseDate) {
            String releaseDate = io.readString("Please enter DVD release date");
            dvd.setReleaseDate(releaseDate);
        }
        boolean updateTheMpaaRating = io.readYesOrNo("Would you like to update"
                + " the DVD's MPAA Rating?") == "yes";
        if (updateTheMpaaRating) {
            String mpaaRating = io.readString("Please enter MPAA rating");
            dvd.setMpaaRating(mpaaRating);
        }
        boolean updateTheDirectorsName = io.readYesOrNo("Would you like to update"
                + " the DVD's director's name?") == "yes";
        if (updateTheDirectorsName) {
            String directorsName = io.readString("Please enter director's name");
            dvd.setDirectorsName(directorsName);
        }
        boolean updateTheStudio = io.readYesOrNo("Would you like to update"
                + " the DVD's studio?") == "yes";
        if (updateTheStudio) {
            String studio = io.readString("Please enter studio");
            dvd.setStudio(studio);
        }
        boolean updateTheNotes = io.readYesOrNo("Would you like to update you notes/"
                + "review of the DVD?") == "yes";
        if (updateTheNotes) {
            String notes = io.readString("Please enter your rating and/or notes for the DVD");
            dvd.setUserNotes(notes);
        }
        return dvd;
    }
    public void displayDvds(ArrayList<Dvd> allDvds) {
        for (Dvd dvd : allDvds) {
            displayDvd(dvd);
        }
    }
    public void displayDvd(Dvd dvd) {
        String dvdInformation = String.format("Title: %s | Release Date:"
                    + " %s | MPAA Rating: %s | Director's Name: %s | "
                    + "Studio: %s | Notes: %s ",
                    dvd.getDvdTitle(),
                    dvd.getReleaseDate(),
                    dvd.getMpaaRating(),
                    dvd.getDirectorsName(),
                    dvd.getStudio(),
                    dvd.getUserNotes());
          io.print(dvdInformation);
    }
    public void displayErrorMessage(String errorMessage) {
        io.print("=== ERROR ===");
        io.print(errorMessage);
    }
    public void print(String message) {
        io.print(message);
    }
}
