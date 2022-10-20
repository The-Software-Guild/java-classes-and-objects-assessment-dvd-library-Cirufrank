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

public class DvdLibraryController {
    DvdLibraryView view;
    
    public DvdLibraryController(UserIO myIO) {
        this.view = new DvdLibraryView(myIO);
    }
    public void run() {
        view.printWelcomeBanner();
        view.printMenuBanner();
        view.printMenu();
        view.getMenuChoice();
        view.printGoodbyeMessage();
    }
}
