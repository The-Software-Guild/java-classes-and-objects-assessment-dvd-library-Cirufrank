/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.we.classroster.service;

import com.we.classroster.dao.ClassRosterPersistenceException;
import com.we.classroster.dto.Student;
import java.util.List;


/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This interface defines the methods we'd like to be available in 
 * any implementation of the Service layer which will act as the business logic of our application
 */

public interface ClassRosterServiceLayer {
    void createStudent(Student student) throws 
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;
    
    Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;
}
