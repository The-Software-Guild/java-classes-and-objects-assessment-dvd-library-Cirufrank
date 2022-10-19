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
import com.we.classroster.dao.ClassRosterDaoException;
import com.we.classroster.dao.ClassRosterDaoFileImpl;
import com.we.classroster.dto.Student;
import com.we.classroster.ui.ClassRosterView;
import java.util.List;

public class ClassRosterController {
    private ClassRosterView view;
    private ClassRosterDao dao;
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
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
                }
            }
            exitMessage();
       } catch(ClassRosterDaoException error) {
           view.displayErrorMessage(error.getMessage());
       }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    private void listStudents() throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList); 
    }
    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplaySudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    } 
    private void exitMessage() {
        view.displayExitBanner();
    }
}
