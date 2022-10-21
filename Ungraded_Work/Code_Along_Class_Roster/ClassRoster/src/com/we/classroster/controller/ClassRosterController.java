/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.controller;



/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This controller is the "brains" of our application's
 * operations and controls when the menu system is displayed,
 * processes user input, and calls a method that performs
 * the needed action based on the user's menu choice
 */

import com.we.classroster.dao.ClassRosterDao;
import com.we.classroster.dao.ClassRosterPersistenceException;
import com.we.classroster.dao.ClassRosterDaoFileImpl;
import com.we.classroster.dto.Student;
import com.we.classroster.service.ClassRosterDataValidationException;
import com.we.classroster.service.ClassRosterDuplicateIdException;
import com.we.classroster.service.ClassRosterServiceLayer;
import com.we.classroster.ui.ClassRosterView;
import java.util.List;

public class ClassRosterController {
    private ClassRosterView view;
    private ClassRosterServiceLayer service;
    
    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while(keepGoing) {
            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    System.out.println("Unknown");
                }
            }
            exitMessage();
       } catch(ClassRosterPersistenceException error) {
           view.displayErrorMessage(error.getMessage());
       }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student newStudent = view.getNewStudentInfo();
            try {
                service.createStudent(newStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch(ClassRosterDuplicateIdException | 
                    ClassRosterDataValidationException error) {
                hasErrors = true;
                view.displayErrorMessage(error.getMessage());
            }
        } while (hasErrors);
        
        
    }
    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList); 
    }
    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplaySudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = service.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    } 
    private void exitMessage() {
        view.displayExitBanner();
    }
}
