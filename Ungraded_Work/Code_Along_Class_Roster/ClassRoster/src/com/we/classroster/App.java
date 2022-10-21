/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This application allows users to create,
 * read, update, and delete student records
 * It uses the MVC architectural paradigm to organize files
 * in order to keep code DRY while separating concerns
 * Through the use of file storage the records users create
 * and update are able to persist
 */

import com.we.classroster.controller.ClassRosterController;
import com.we.classroster.dao.ClassRosterAuditDao;
import com.we.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.we.classroster.dao.ClassRosterDao;
import com.we.classroster.dao.ClassRosterDaoFileImpl;
import com.we.classroster.service.ClassRosterServiceLayer;
import com.we.classroster.service.ClassRosterServiceLayerImpl;
import com.we.classroster.ui.ClassRosterView;
import com.we.classroster.ui.UserIO;
import com.we.classroster.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);
        controller.run();
    }
}
