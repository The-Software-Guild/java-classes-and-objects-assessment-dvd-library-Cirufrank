/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This class is the implementation fo the Audit DAO interface
 * and defines the methods that allow us to keep track of the students
 * added and removed from our class roster by writing logs of this to the
 * audit file
 */
public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {
    final public static String AUDIT_FILE = "audit.txt";
    
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException error) {
            throw new ClassRosterPersistenceException("Could not persist audit "
                    + "information.", error);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();    }
}
