/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary.controller;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This class acts and the brains of the DVD Library application
 * and delegates tasks to the view and controller to accomplish this app's 
 * operations
 */

import com.we.dvdlibrary.ui.DvdLibraryView;
import com.we.dvdlibrary.ui.UserIO;
import com.we.dvdlibrary.dao.DvdLibraryDao;
import com.we.dvdlibrary.dao.DvdLibraryDaoException;
import com.we.dvdlibrary.dto.Dvd;
import java.util.ArrayList;

public class DvdLibraryController {
    DvdLibraryView view;
    DvdLibraryDao dao;
    private boolean usingMenu = true;
    private int currentChoice = 0;
    final private int LIST_ALL_DVDS = 1, ADD_A_DVD = 2, 
            SEARCH_DVDS_BY_TITLE = 3,
            SEARCH_FOR_EXACT_DVD_MATCH = 4,
            UPDATE_DVD = 5,
            DELETE_DVD = 6,
            EXIT_LIBRARY = 7,
            NO_DVDS = 0;
    //This constructor allows us to initialize our view and dao fields to their 
    //chosen implementations whenever we intitialize a DvdLibraryController instance within the 
    //App.java file's main method. This saves us from hard-coding our view and dao's
    //dependencies and allows us to take advantage of dependency injection's benefits
    public DvdLibraryController(UserIO myIO, DvdLibraryDao myDAO) {
        this.view = new DvdLibraryView(myIO);
        this.dao = myDAO;
    }
    //This is the method called within our App.java file's main method and controller the 
    //main flow of our application
    public void run() {
        view.printWelcomeBanner();
        try {
            while (usingMenu) {
            view.printMenuBanner();
            view.printMenu();
            currentChoice = view.getMenuChoice();
            switch(currentChoice) {
                case LIST_ALL_DVDS:
                    listDvds();
                    break;
                case ADD_A_DVD:
                    addDvd();
                    break;
                case SEARCH_DVDS_BY_TITLE:
                    searchForDvdsByTitle();
                    break;
                case SEARCH_FOR_EXACT_DVD_MATCH:
                    searchForExactMatchDvd();
                    break;
                case UPDATE_DVD:
                    updateDvd();
                    break;
                case DELETE_DVD:
                    removeDvd();
                    break;
                case EXIT_LIBRARY:
                    usingMenu = false;
                    break;
                //Since choice must be within specified range of options, this
                //default case will never run. This is just here incase code 
                //is ever refactored to use it
                default:
                    view.printChoiceNotFoundMessage();
               }
            }
        
            view.printGoodbyeMessage();
        } catch (DvdLibraryDaoException error) {
            view.displayErrorMessage(error.getMessage());
        }
    }
    private void listDvds() throws DvdLibraryDaoException {
        final ArrayList<Dvd> allDvds = dao.getAllDvds();
        if (allDvds.size() == NO_DVDS) view.printNoDvdsFoundMessage();
        else view.displayDvds(allDvds);
        view.readAndPrintPressEnterToContineMessage();
    }
    private void addDvd() throws DvdLibraryDaoException {
        final Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getDvdTitle(), newDvd);
        view.printAddDvdSuccessMessage();
        view.readAndPrintPressEnterToContineMessage();
    }
    private void searchForDvdsByTitle() throws DvdLibraryDaoException {
        final String dvdTitle = view.getDvdTitle();
        final ArrayList<Dvd> matchingDvds = dao.getDvdsByTitle(dvdTitle);
        if (matchingDvds.size() == NO_DVDS) view.printNoDvdsFoundMessage();
        else view.displayDvds(matchingDvds);
        view.readAndPrintPressEnterToContineMessage();
    }
    private void searchForExactMatchDvd() throws DvdLibraryDaoException{
        final String dvdTitle = view.getDvdTitle();
        final Dvd dvd = dao.getDvd(dvdTitle);
        if (dvd == null) view.printNoExactMatchFoundMessage();
        else view.displayDvd(dvd);
        view.readAndPrintPressEnterToContineMessage();
    }
    private void updateDvd() throws DvdLibraryDaoException {
        final String dvdTitle = view.getDvdTitle();
        final Dvd dvd = dao.getDvd(dvdTitle);
        if (dvd == null) view.printNoDvdsFoundMessage();
        else {
            Dvd updatedDvd = view.getDvdUpdateFields(dvd);
            dao.editDvd(dvdTitle, updatedDvd);
            view.printUpdateDvdSucceessMessage();
        }
        view.readAndPrintPressEnterToContineMessage();
    }
    private void removeDvd() throws DvdLibraryDaoException {
        final String dvdTitle = view.getDvdTitle();
        final Dvd removedDvd = dao.removeDvd(dvdTitle);
        if (removedDvd == null) view.printNoDvdsFoundMessage();
        else {
            view.printRemovedDvdSuccessMessage();
        }
        view.readAndPrintPressEnterToContineMessage();
    }
}
