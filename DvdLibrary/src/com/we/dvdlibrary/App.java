/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This project is a DVD Library application that 
 * allows users to create, read, update, and delete DVDs within 
 * a library, using files for storage persistence
 */

import com.we.dvdlibrary.ui.UserIOConsoleImpl;
import com.we.dvdlibrary.controller.DvdLibraryController;
import com.we.dvdlibrary.dao.DvdLibraryDaoFileImpl;
public class App {
    public static void main(String[] args) {
        //Through the constructors we have specifed within the necessary classes, we
        //are able to implement dependency injection within our code
        DvdLibraryController controller = new DvdLibraryController(new UserIOConsoleImpl(), new DvdLibraryDaoFileImpl());
        controller.run();
        
    }
}
