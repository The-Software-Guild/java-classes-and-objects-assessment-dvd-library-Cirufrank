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
import com.we.dvdlibrary.dto.Dvd;
import java.util.ArrayList;

public class DvdLibraryController {
    DvdLibraryView view;
    DvdLibraryDao dao;
    private boolean usingMenu = true;
    private int currentChoice = 0;
    public DvdLibraryController(UserIO myIO, DvdLibraryDao myDAO) {
        this.view = new DvdLibraryView(myIO);
        this.dao = myDAO;
    }
    public void run() {
        view.printWelcomeBanner();
        while (usingMenu) {
            view.printMenuBanner();
            view.printMenu();
            currentChoice = view.getMenuChoice();
            switch(currentChoice) {
                case 1:
                    listDvds();
                    break;
                case 2:
                    addDvd();
                    break;
                case 3:
                    searchForDvdsByTitle();
                    break;
                case 4:
                    searchForExactMatchDvd();
                    break;
                case 5:
                    updateDvd();
                    break;
                case 6 :
                    removeDvd();
                    break;
                case 7:
                    usingMenu = false;
                    break;
                default:
                    view.print("Choice not found");
            }
        }
        
        view.printGoodbyeMessage();
    }
    private void listDvds() {
        final ArrayList<Dvd> allDvds = dao.getAllDvds();
        view.displayDvds(allDvds);
        view.readAndPrintPressEnterToContineMessage();
    }
    private void addDvd() {
        final Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getDvdTitle(), newDvd);
        view.printAddDvdSuccessMessage();
        view.readAndPrintPressEnterToContineMessage();
    }
    private void searchForDvdsByTitle() {
        final String dvdTitle = view.getDvdTitle();
        final ArrayList<Dvd> matchingDvds = dao.getDvdsByTitle(dvdTitle);
        if (matchingDvds == null) view.printNoDvdsFoundMessage();
        else view.displayDvds(matchingDvds);
        view.readAndPrintPressEnterToContineMessage();
    }
    private void searchForExactMatchDvd() {
        final String dvdTitle = view.getDvdTitle();
        final Dvd dvd = dao.getDvd(dvdTitle);
        if (dvd == null) view.printNoExactMatchFoundMessage();
        else view.displayDvd(dvd);
        view.readAndPrintPressEnterToContineMessage();
    }
    private void updateDvd() {
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
    private void removeDvd() {
        final String dvdTitle = view.getDvdTitle();
        final Dvd removedDvd = dao.removeDvd(dvdTitle);
        if (removedDvd == null) view.printNoDvdsFoundMessage();
        else {
            view.printRemovedDvdSuccessMessage();
        }
        view.readAndPrintPressEnterToContineMessage();
    }
}
