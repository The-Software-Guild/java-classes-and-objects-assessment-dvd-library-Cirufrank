/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.controller;



/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This controller is the "brains" of our application's
 * operations and controls when the menu system is displayed,
 * processes user input, and calls a method that performs
 * the needed action based on the user's menu choice
 */

import com.we.classroster.ui.UserIO;
import com.we.classroster.ui.UserIOConsoleImpl;
import com.we.classroster.ui.ClassRosterView;

public class ClassRosterController {
    private UserIO io = new UserIOConsoleImpl();
    private ClassRosterView view = new ClassRosterView();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing) {
            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                case 1:
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    io.print("CREATE STUDENT");
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("GOOD BYE");
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
}
