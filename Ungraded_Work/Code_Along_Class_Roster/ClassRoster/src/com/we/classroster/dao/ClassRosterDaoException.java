/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.dao;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This class allows us to create a custom exception that
 * will be thrown if any error happen throughout data access within
 * our application
 */
public class ClassRosterDaoException extends Exception {
    public ClassRosterDaoException(String message) {
        super(message);
    }
    public ClassRosterDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
