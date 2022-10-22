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
 * and provides an interface for all fields and methods necessary to display information 
 * to a user
 */

public class DvdLibraryView {
    final private String WELCOME_BANNER = "=== WelCOME TO THE DVD LIBRARY ===",
            MENU_BANNER = "=== MENU ===",
            PRESS_ENTER_TO_CONTINUE = "Press enter to continue...",
            GOODBYE_MESSAGE = "=== Goodbye ===",
            ERROR_BANNER = "=== ERROR ===",
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
            REMOVE_DVD_SUCCESS_MESSAGE = "=== Successfully removed the DVD ===",
            CHOICE_NOT_FOUND_MESSAGE = "Choice not found.",
            DVD_INFORMATION_STRING_FORMAT = "Title: %s | Release Date:"
                    + " %s | MPAA Rating: %s | Director's Name: %s | "
                    + "Studio: %s | Notes: %s ";
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
        final String ENTER_DVD_TITLE_PROMPT = "Please enter the title of the DVD";
        String dvdTitle = io.readString(ENTER_DVD_TITLE_PROMPT);
        return dvdTitle;
    }
    public void displayMenuChoice(int menuChoice) {
        final String YOU_CHOSE_STRING = "You chose: ";
        io.print(YOU_CHOSE_STRING + menuChoice);
    }
    public void printNoDvdsFoundMessage() {
        io.print(NO_DVDS_FOUND_MESSAGE);
    }
    public void printNoExactMatchFoundMessage() {
        io.print(NO_EXACT_MATCH_MESSAGE);
    }
    public void printChoiceNotFoundMessage() {
        io.print(CHOICE_NOT_FOUND_MESSAGE);
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
        final String ENTER_DVD_TITLE_PROMPT = "Please enter DVD title",
                ENTER_RELEASE_DATE_PROMPT = "Please enter DVD release date",
                ENTER_MPAA_RATING_PROMPT = "Please enter MPAA rating",
                ENTER_DIRECTOR_NAME_PROMPT = "Please enter director's name",
                ENTER_STUDIO_PROMPT = "Please enter studio",
                ENTER_USER_NOTES_PROMPT = "Please enter your rating and/or notes for the DVD";
        
        final Dvd newDvd = new Dvd();
        String dvdTitle = io.readString(ENTER_DVD_TITLE_PROMPT);
        String releaseDate = io.readString(ENTER_RELEASE_DATE_PROMPT);
        String mpaaRating = io.readString(ENTER_MPAA_RATING_PROMPT);
        String directorsName = io.readString(ENTER_DIRECTOR_NAME_PROMPT);
        String studio = io.readString(ENTER_STUDIO_PROMPT);
        String notes = io.readString(ENTER_USER_NOTES_PROMPT);
        newDvd.setDvdTitle(dvdTitle);
        newDvd.setReleaseDate(releaseDate);
        newDvd.setMpaaRating(mpaaRating);
        newDvd.setDirectorsName(directorsName);
        newDvd.setStudio(studio);
        newDvd.setUserNotes(notes);
        return newDvd;
    } 
    public Dvd getDvdUpdateFields(Dvd dvd) {
        //Ask this user if they'd like to update a field and if so, allow them
        //to do so. Then return the updated Dvd object once all updates have been
        //made
        final String UPDATE_RELEASE_DATE_PROMPT = "Would you like to update the DVD's release date?",
                ENTER_DVD_RELEASE_DATE_PROMPT = "Please enter DVD release date",
                UPDATE_MPAA_RATING_PROMPT = "Would you like to update the DVD's MPAA Rating?",
                ENTER_MPAA_RATING_PROMPT = "Please enter MPAA rating",
                UPDATE_DIRECTOR_NAME_PROMPT = "Would you like to update the DVD's director's name?",
                ENTER_DIRECTOR_NAME_PROMPT = "Please enter director's name",
                UPDATE_STUDIO_PROMPT = "Would you like to update the DVD's studio?",
                ENTER_STUDIO_PROMPT = "Please enter studio",
                UPDATE_USER_NOTES_PROMPT = "Would you like to update your notes/review of the DVD?",
                ENTER_USER_NOTES_PROMPT = "Please enter your rating and/or notes for the DVD",
                YES_ANSWER = "yes";
        
        boolean updateTheReleaseDate = io.readYesOrNo(UPDATE_RELEASE_DATE_PROMPT) == YES_ANSWER;
        if (updateTheReleaseDate) {
            String releaseDate = io.readString(ENTER_DVD_RELEASE_DATE_PROMPT);
            dvd.setReleaseDate(releaseDate);
        }
        boolean updateTheMpaaRating = io.readYesOrNo(UPDATE_MPAA_RATING_PROMPT) == YES_ANSWER;
        if (updateTheMpaaRating) {
            String mpaaRating = io.readString(ENTER_MPAA_RATING_PROMPT);
            dvd.setMpaaRating(mpaaRating);
        }
        boolean updateTheDirectorsName = io.readYesOrNo(UPDATE_DIRECTOR_NAME_PROMPT) == YES_ANSWER;
        if (updateTheDirectorsName) {
            String directorsName = io.readString(ENTER_DIRECTOR_NAME_PROMPT);
            dvd.setDirectorsName(directorsName);
        }
        boolean updateTheStudio = io.readYesOrNo(UPDATE_STUDIO_PROMPT) == YES_ANSWER;
        if (updateTheStudio) {
            String studio = io.readString(ENTER_STUDIO_PROMPT);
            dvd.setStudio(studio);
        }
        boolean updateTheNotes = io.readYesOrNo(UPDATE_USER_NOTES_PROMPT) == YES_ANSWER;
        if (updateTheNotes) {
            String notes = io.readString(ENTER_USER_NOTES_PROMPT);
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
        //Format the DVD information display and display this information
        //to users
        String dvdInformation = String.format(DVD_INFORMATION_STRING_FORMAT,
                    dvd.getDvdTitle(),
                    dvd.getReleaseDate(),
                    dvd.getMpaaRating(),
                    dvd.getDirectorsName(),
                    dvd.getStudio(),
                    dvd.getUserNotes());
          io.print(dvdInformation);
    }
    public void displayErrorMessage(String errorMessage) {
        io.print(ERROR_BANNER);
        io.print(errorMessage);
    }
}
