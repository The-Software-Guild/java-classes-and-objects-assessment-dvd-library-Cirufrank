/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.ui;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This is an console IO implementation of the 
 * UserIO interface
 */

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    final private Scanner console = new Scanner(System.in);
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
    
    @Override
    public String readString(String msgPrompt) {
        print(msgPrompt);
        return console.nextLine();
    }
    
    @Override
    public int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while(invalidInput) {
            try {
                String stringValue = readString(msgPrompt);
                num = Integer.parseInt(stringValue);
                invalidInput = false;
            } catch(NumberFormatException error) {
                print("Input error. Please try again.");
            }
        }
        return num;
    }
    
    @Override
    public int readInt(String msgPrompt, int min, int max) {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);
        
        return result;
    }
    
    @Override
    public long readLong(String msgPrompt) {
        while(true) {
            try {
                return Long.parseLong(readString(msgPrompt));
            } catch(NumberFormatException error) {
                print("Input error. Please try again");
            }
        }
    }
    
    @Override
    public long readLong(String msgPrompt, long min, long max) {
        long result;
        do {
           result = readLong(msgPrompt); 
        } while(result < min || result > max);
        
        return result;
    }
    
    @Override
    public float readFloat(String msgPrompt) {
        while(true) {
            try {
                return Float.parseFloat(readString(msgPrompt));
            } catch(NumberFormatException error) {
                print("Invalid error. Please try again.");
            }
        }
    }
    
    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        float result;
        do {
            result = readFloat(msgPrompt);
        } while(result < min || result > max);
        
        return result;
    }
    
    @Override
    public double readDouble(String msgPrompt) {
        while(true) {
            try {
                return Double.parseDouble(readString(msgPrompt));
            } catch(NumberFormatException error) {
                print("Input error. Please try again.");
            }
        }
    }
    
    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        double result;
        do {
            result = readDouble(msgPrompt);
        } while(result < min || result > max);
        
        return result;
    }
}
