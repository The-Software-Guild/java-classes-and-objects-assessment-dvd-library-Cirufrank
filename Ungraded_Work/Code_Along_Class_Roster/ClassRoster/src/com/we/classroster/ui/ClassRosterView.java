/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.ui;

/**
 *
 * @author ciruf
 */

public class ClassRosterView {
    private UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a Student");
            io.print("4. Remove a Student");
            io.print("5. Exit");
            
            return io.readInt("Please"
                    + " select from the above "
                    + "choices.", 1, 5);
    }
}
