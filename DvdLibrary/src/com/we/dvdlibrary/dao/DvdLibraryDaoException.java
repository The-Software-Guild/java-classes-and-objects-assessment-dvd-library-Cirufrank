/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary.dao;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This class is responsible for our application-specific exceptions 
 * that will help up uphold the OOP standard of encapsulation.
 * We extend the Exception class so that our Exception inherits
 * the methods and properties of that super class and so our Exception is 
 * checked (since we want to make sure to require the handling of these exceptions
 * if they are thrown)
 */
public class DvdLibraryDaoException extends Exception {
    public DvdLibraryDaoException(String message) {
        super(message);
    }
    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
