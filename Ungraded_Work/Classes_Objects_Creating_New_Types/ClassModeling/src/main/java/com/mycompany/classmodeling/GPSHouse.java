/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Exercise: Class Modeling
 * 
 * @description This is a demonstration of how to extend classes 
 * and how constructors are required for both the parent and child class
 *      
 */
public class GPSHouse extends House {
    private String gpsTrackerType;
    private String gpsTrackerCompany;
    private int gpsTrackerNumber;
    GPSHouse(){
    }
    GPSHouse(String passedColor) {
        super(passedColor);
    }
    GPSHouse(String passedColor, String passedAddress) {
        super(passedColor, passedAddress);
    }
    GPSHouse(String passedColor, String passedAddress, String passedMainMaterial) {
        super(passedColor, passedAddress, passedMainMaterial);
    }
    GPSHouse(String passedColor, String passedAddress, String passedMainMaterial, int passedNumberOfWindows) {
        super(passedColor, passedAddress, passedMainMaterial, passedNumberOfWindows);
    }
    GPSHouse(String passedColor, String passedAddress, 
            String passedMainMaterial, 
            int passedNumberOfWindows, String passedTrackerType) {
        super(passedColor, passedAddress, 
                passedMainMaterial, 
                passedNumberOfWindows);
        gpsTrackerType = passedTrackerType;
    }
    GPSHouse(String passedColor, String passedAddress, 
            String passedMainMaterial, 
            int passedNumberOfWindows, String passedTrackerType, 
            String passedTrackerCompany) {
        super(passedColor, passedAddress, 
                passedMainMaterial, 
                passedNumberOfWindows);
        gpsTrackerType = passedTrackerType;
        gpsTrackerCompany = passedTrackerCompany;
    }
    GPSHouse(String passedColor, String passedAddress, 
            String passedMainMaterial, 
            int passedNumberOfWindows, String passedTrackerType, 
            String passedTrackerCompany, int passedTrackerNumber) {
        super(passedColor, passedAddress, 
                passedMainMaterial, 
                passedNumberOfWindows);
        gpsTrackerType = passedTrackerType;
        gpsTrackerCompany = passedTrackerCompany;
        gpsTrackerNumber = passedTrackerNumber;
    }
    public String getGpsTrackerType() {
        return gpsTrackerType;
    }
    public String getGpsTrackerCompany() {
        return gpsTrackerCompany;
    }
    public int getGPSTrackerNumber() {
        return gpsTrackerNumber;
    }
    
}
