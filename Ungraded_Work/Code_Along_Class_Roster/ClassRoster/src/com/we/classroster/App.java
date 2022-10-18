/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This application allows users to create,
 * read, update, and delete student records
 * It uses the MVC architectural paradigm to organize files
 * in order to keep code DRY while separating concerns
 * Through the use of file storage the records users create
 * and update are able to persist
 */

import com.we.classroster.controller.ClassRosterController;

public class App {
    public static void main(String[] args) {
        ClassRosterController controller = new ClassRosterController();
        controller.run();
    }
}
