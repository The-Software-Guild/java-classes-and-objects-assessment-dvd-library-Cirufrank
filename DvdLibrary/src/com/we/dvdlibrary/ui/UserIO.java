/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.we.dvdlibrary.ui;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This interface defines the methods to be implemented by this DVD
 * Library application's User interface
 */
public interface UserIO {
    void print(String message);
    String readString(String message);
    int readInt(String message);
    int readInt(String message, int min, int max);
}
