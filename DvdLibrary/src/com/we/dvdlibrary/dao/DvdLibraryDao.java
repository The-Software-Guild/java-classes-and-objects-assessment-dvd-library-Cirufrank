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
    Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryDaoException;
    /**
     * Removes the given DVD from the library and associates it with the given
     * dvdTitle. If there is already a DVD associated with the given dvdTitle it
     * will return that DVD object, otherwise it will return null.
     *
     * @param dvdTitle title with which DVD is to be associated
     * @return the DVD object previously associated with the given dvdTitle if
     * it exists, null otherwise
     */
    Dvd removeDvd(String dvdTitle)throws DvdLibraryDaoException;
    /**
     * Edits the given DVD from the library and applies the specified changes. If there is already a DVD associated with the given dvdTitle it
     * will return that DVD object, otherwise it will return null.
     *
     * @param dvdTitle title with which DVD is to be associated
     * @param dvd a DVD object of the not yet updated fields of the DVD
     * @return the DVD object previously associated with the given dvdTitle if
     * it exists, null otherwise
     */
    Dvd editDvd(String dvdTitle, Dvd dvd) throws DvdLibraryDaoException;

    /**
     * Returns an ArrayList of all DVDs in the library.
     *
     * @return ArrayList containing all DVDs in the library.
     */
    ArrayList<Dvd> getAllDvds() throws DvdLibraryDaoException;
    /**
     * Retrieves the given DVD from the library. If no DVD exists it will return
     * an empty ArrayList
     *
     * @param dvdTitle title with which DVD is to be associated
     * @return the DVD object associated with the given dvdTitle if
     * it exists, [] otherwise
     */
    Dvd getDvd(String dvdTitle) throws DvdLibraryDaoException;
    /**
     * Retrieves an ArrayList of the DVDs that contain the sequence of 
     * characters provided by the user, from the library. If no DVD matches the title 
     * given it will return an empty array list
     *
     * @param dvdTitle title with which DVD is to be associated
     * @return the DVD object associated with the given dvdTitle if
     * it exists, [] otherwise
     */
    ArrayList<Dvd> getDvdsByTitle(String dvdTitle) throws DvdLibraryDaoException;
}
