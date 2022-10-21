/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.service;

import com.we.classroster.dao.ClassRosterAuditDao;
import com.we.classroster.dao.ClassRosterDao;
import com.we.classroster.dao.ClassRosterPersistenceException;
import com.we.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This class implements the service layer interface and is 
 * responsible for defining the methods that will provide the business logic to 
 * our code
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {
    private ClassRosterAuditDao auditDao;
    private ClassRosterDao dao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, 
            ClassRosterDataValidationException, 
            ClassRosterPersistenceException {
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
            "ERROR: Could not create student/ Student Id " +
                    student.getStudentId() + " already exists");
        }
        
        validateStudentData(student);
        
        dao.addStudent(student.getStudentId(), student);
        
        auditDao.writeAuditEntry(
                "Student " + student.getStudentId() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        //Pass-through method
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0)
            
            throw new ClassRosterDataValidationException(
            "ERROR: All fields [First Name, lAst Name, Cohort are required.");
    }
    
}
