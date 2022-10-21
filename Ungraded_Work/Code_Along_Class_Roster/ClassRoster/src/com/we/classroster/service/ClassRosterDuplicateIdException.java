/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.service;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This class allows us to create a custom exception that
 * will be thrown if a user tries to add a student with an ID already
 * existing within the Roster
 */
public class ClassRosterDuplicateIdException extends Exception {
    public ClassRosterDuplicateIdException(String message) {
        super(message);
    }
    
    public ClassRosterDuplicateIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
