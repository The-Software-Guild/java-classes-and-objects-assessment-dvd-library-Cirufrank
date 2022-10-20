/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary.dto;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 * 
 * @description This class acts as the DTO of the application
 */
public class Dvd {
    private String dvdTitle, releaseDate, mpaaRating, directorsName, studio, userNotes;
    
    Dvd() {
        
    }
    
    public String getDvdTitle() {
        return dvdTitle;
    }
    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getMpaaRate() {
        return mpaaRating;
    }
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    public String getDirectorsName() {
        return directorsName;
    }
    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }
    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public String getUserNotes() {
        return userNotes;
    }
    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
}
