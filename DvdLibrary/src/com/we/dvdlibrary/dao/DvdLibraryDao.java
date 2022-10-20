/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.we.dvdlibrary.dao;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Assessment: DVD Library
 *
 * @description This interface defines the methods to be implemented by this DVD
 * Library application's DAO/DAOs
 */
import com.we.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DvdLibraryDao {

    /**
     * Adds the given DVD to the library and associates it with the given
     * dvdTitle. If there is already a DVD associated with the given dvdTitle it
     * will return that DVD object, otherwise it will return null.
     *
     * @param dvdTitle title with which DVD is to be associated
     * @param dvd DVD to be added to the roster
     * @return the DVD object previously associated with the given dvdTitle if
     * it exists, null otherwise
     */
    Dvd addDvd(String dvdTitle, Dvd dvd);

    Dvd removeDvd(String dvdTitle);

    Dvd editDvd(String dvdTitle, Dvd dvd);

    /**
     * Returns a List of all DVDs in the library.
     *
     * @return List containing all DVDs in the library.
     */
    ArrayList<Dvd> getAllDvds();

    Dvd getDvd(String dvdTitle);

    ArrayList<Dvd> getDvdsByTitle(String dvdTitle);
}
