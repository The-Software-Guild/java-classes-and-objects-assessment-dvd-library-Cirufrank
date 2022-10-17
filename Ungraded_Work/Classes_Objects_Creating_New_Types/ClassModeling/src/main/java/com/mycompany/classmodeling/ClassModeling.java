/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.classmodeling;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Exercise: Class Modeling
 * 
 * @description This program demonstrates how to properly model and extend classes
 *      
 */
public class ClassModeling {

    public static void main(String[] args) {
        final GPSHouse theGpsHouse = new GPSHouse("Green", 
                "1234 Test Street, Test Place, Test City, Test 12343", 
                "Brick", 5, "Global", "Google", 43455454);
        final GPSHouse testHouse = new GPSHouse("Purple");
        final GPSHouse testHouse2 = new GPSHouse();
        print(testHouse.getColor());
        print("The color of this house is: " + theGpsHouse.getColor());
        theGpsHouse.setColor("Orange");
        print("Now the color of this house is: " + theGpsHouse.getColor());
    }
    public static void print(String message) {
        System.out.println(message);
    }
    public static void print(int integer) {
        System.out.println(integer);
    }
}
