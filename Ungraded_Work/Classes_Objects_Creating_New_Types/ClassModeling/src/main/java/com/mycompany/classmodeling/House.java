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
 * @description This is a demonstration of how to create a class
 * and its constructors
 *      
 */
public class House {
    private String color;
    private String address;
    private String mainMaterial;
    private int numOfWindows;
    House() {
    }
    House(String passedColor) {
        this.color = passedColor;
    }
    House(String passedColor, String passedAddress) {
        this.color = passedColor;
        this.address = passedAddress;
    }
    House(String passedColor, String passedAddress, String passedMainMaterial) {
        this.color = passedColor;
        this.address = passedAddress;
        this.mainMaterial = passedMainMaterial;
    }
    House(String passedColor, String passedAddress, String passedMainMaterial, int passedNumOfWindows) {
        this.color = passedColor;
        this.address = passedAddress;
        this.mainMaterial = passedMainMaterial;
        this.numOfWindows = passedNumOfWindows;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String newColor) {
        this.color = newColor;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String newNeighborhood) {
        this.address = newNeighborhood;
    }
    public String getMainMaterial() {
        return mainMaterial;
    }
    public void setMainMaterial(String newMainMaterial) {
        this.mainMaterial = newMainMaterial;
    }
    public int getNumOfWindows() {
        return numOfWindows;
    }
    public void setNumOfWindows(int newWindowNum) {
        this.numOfWindows = newWindowNum;
    }
}
