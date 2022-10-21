/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.we.classroster.dao;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This interface acts as the interface of the DAO(s) of our application
 * and allows users to add, delete, update, and retrieve student
 * information
 */

import com.we.classroster.dto.Student;
import java.util.List;
public interface ClassRosterDao {
    /**
     * Adds the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will
     * return null.
     *
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given  
     * student id if it exists, null otherwise
     */
    
    Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException;
    
    /**
     * Returns a List of all students in the roster.
     *
     * @return List containing all students in the roster.
     */
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    /**
     * Returns the student object associated with the given student id.
     * Returns null if no such student exists
     *
     * @param studentId ID of the student to retrieve
     * @return the Student object associated with the given student id,  
     * null if no such student exists
     */
    
    Student getStudent(String studentId) throws ClassRosterPersistenceException;
    
     /**
     * Removes from the roster the student associated with the given id.
     * Returns the student object that is being removed or null if
     * there is no student associated with the given id
     *
     * @param studentId id of student to be removed
     * @return Student object that was removed or null if no student
     * was associated with the given student id
     */
    
    Student removeStudent(String studentId) throws ClassRosterPersistenceException;
}
