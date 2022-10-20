/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary.dao;

import com.we.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This class acts as the file implementation of the DVD Library's data access object
 * This class provides methods that will allow users to add, edit, update, delete, and retrieve DVDs 
 * from the library
 */

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    private Map<String, Dvd> dvds = new HashMap<>();
    
    @Override
    public Dvd addDvd(String dvdTitle, Dvd dvd) {
        final Dvd prevDvd = dvds.put(dvdTitle, dvd);
        return prevDvd;
    }
    
    @Override
    public Dvd removeDvd(String dvdTitle) {
        final Dvd removedDvd = dvds.remove(dvdTitle);
        return removedDvd;
    }
    
    @Override
    public Dvd editDvd(String dvdTitle, Dvd dvd) {
        final Dvd prevDvd = dvds.put(dvdTitle, dvd);
        return prevDvd;
    }
    
    @Override
    public ArrayList<Dvd> getAllDvds() {
        final ArrayList<Dvd> allDvds = new ArrayList<Dvd>(dvds.values());
        return allDvds;
    }
    
    @Override
    public Dvd getDvd(String dvdTitle) {
        final Dvd dvd = dvds.get(dvdTitle);
        return dvd;
    }
    
    @Override
    public ArrayList<Dvd> getDvdsByTitle(String dvdTitle) {
        final ArrayList<Dvd> matchingDvds = new ArrayList<>();
        final String lowerCaseTitle = lowerCase(dvdTitle);
        Set<String> dvdTitles = dvds.keySet();
        for (String currentTitle : dvdTitles) {
            final Dvd currentDvd = dvds.get(currentTitle);
            final String loweredCurrentTitle = lowerCase(currentTitle);
            if (loweredCurrentTitle.contains(lowerCaseTitle)) {
                matchingDvds.add(currentDvd);
            }
        }
        return matchingDvds;
    }
    
    public String lowerCase(String string) {
        return string.toLowerCase().intern();
    }
    
    
}
