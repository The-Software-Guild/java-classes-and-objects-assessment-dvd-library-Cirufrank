/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.dvdlibrary.dao;

import com.we.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This class acts as the file implementation of the DVD Library's data access object interface
 * This class provides methods that will allow users to add, edit, update, delete, and retrieve DVDs 
 * from the library
 */

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String DVD_LIBRARY_FILE = "dvd_library.txt", DELIMITER = "::",
            COULD_NOT_LOAD_DVDS_INTO_MEMORY_MSG = "-_- Could not load DVD Library data into memory. ",
            COULD_NOT_SAVE_DVD_DATA_MSG = "Could not save DVD data";
    
    @Override
    public Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryDaoException {
        loadDvdLibrary();
        final Dvd prevDvd = dvds.put(dvdTitle, dvd);
        writeDvdLibrary();
        return prevDvd;
    }
    
    @Override
    public Dvd removeDvd(String dvdTitle) throws DvdLibraryDaoException {
        loadDvdLibrary();
        final Dvd removedDvd = dvds.remove(dvdTitle);
        writeDvdLibrary();
        return removedDvd;
    }
    
    @Override
    public Dvd editDvd(String dvdTitle, Dvd dvd) throws DvdLibraryDaoException {
        loadDvdLibrary();
        final Dvd prevDvd = dvds.put(dvdTitle, dvd);
        writeDvdLibrary();
        return prevDvd;
    }
    
    @Override
    public ArrayList<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadDvdLibrary();
        final ArrayList<Dvd> allDvds = new ArrayList<Dvd>(dvds.values());
        return allDvds;
    }
    
    @Override
    public Dvd getDvd(String dvdTitle) throws DvdLibraryDaoException {
        loadDvdLibrary();
        final Dvd dvd = dvds.get(dvdTitle);
        return dvd;
    }
    
    @Override
    public ArrayList<Dvd> getDvdsByTitle(String dvdTitle) throws DvdLibraryDaoException {
        //(Case insensitive) Check to see if any DVDs in our library contain the sequence of
        //characters input by the user (dvdTitle), and if so, return those DVDs to the called of this method
        loadDvdLibrary();
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
    public Dvd unmarshallDvd(String dvdAsText) {
        //Translate a text representation of a Dvd object into a Dvd object and 
        //return that Dvd object
        final int TITLE_INDEX = 0, RELEASE_DATE_INDEX = 1, 
                MPAA_RATING_INDEX = 2, DIRECTORS_NAME_INDEX = 3, 
                STUDIO_INDEX = 4,
                USER_NOTES_INDEX = 5;
        
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        Dvd dvdFromFile = new Dvd();
        dvdFromFile.setDvdTitle(dvdTokens[TITLE_INDEX]);
        dvdFromFile.setReleaseDate(dvdTokens[RELEASE_DATE_INDEX]);
        dvdFromFile.setMpaaRating(dvdTokens[MPAA_RATING_INDEX]);
        dvdFromFile.setDirectorsName(dvdTokens[DIRECTORS_NAME_INDEX]);
        dvdFromFile.setStudio(dvdTokens[STUDIO_INDEX]);
        dvdFromFile.setUserNotes(dvdTokens[USER_NOTES_INDEX]);
        return dvdFromFile;
        
    }
    private void loadDvdLibrary() throws DvdLibraryDaoException {
        //Open the Dvd library file responsile for stroage persistence and 
        //load the Dvd objects into memory;
        Scanner scanner;
        try {
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException error) {
            throw new DvdLibraryDaoException(
            COULD_NOT_LOAD_DVDS_INTO_MEMORY_MSG, error);
        }
        
        String currentLine;
        Dvd currentDvd;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            dvds.put(currentDvd.getDvdTitle(), currentDvd);
        }
        scanner.close();
    }
    private String marshallDvd(Dvd aDvd) {
         //Translate a Dvd object into text to be stored within a file
         String dvdAsText = "";
         dvdAsText += aDvd.getDvdTitle() + DELIMITER;
         dvdAsText += aDvd.getReleaseDate() + DELIMITER;
         dvdAsText += aDvd.getMpaaRating() + DELIMITER;
         dvdAsText += aDvd.getDirectorsName() + DELIMITER;
         dvdAsText += aDvd.getStudio() + DELIMITER;
         dvdAsText += aDvd.getUserNotes();
         return dvdAsText;
    }
    private void writeDvdLibrary() throws DvdLibraryDaoException {
        //Translate the Dvd object in memory into text and write this text into 
        //memory
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        } catch (IOException error) {
            throw new DvdLibraryDaoException(
            COULD_NOT_SAVE_DVD_DATA_MSG, error);
        }
        
        String dvdAsText = "";
        ArrayList<Dvd> dvdList = getAllDvds();
        for (Dvd currentDvd : dvdList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
    
}
