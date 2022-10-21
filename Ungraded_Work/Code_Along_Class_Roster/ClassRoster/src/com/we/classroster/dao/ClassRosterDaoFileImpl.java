/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.we.classroster.dao;

import com.we.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Cirũ Franklin (she/they), Software Engineer
 * @course DI002 Full Stack Development Using Java and React (2210)
 * @project Code Along: Class Roster
 * 
 * @description This class implements the DAO for our class roster 
 * application through file storage
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Student> students = new HashMap<>();
    @Override
    public Student addStudent(String studentId, Student student) throws
            ClassRosterPersistenceException {
        loadRoster();
        Student prevStudent = students.put(studentId, student);
        writeRoster();
        return prevStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException{
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    private Student unmarshallStudent(String studentAsText) {
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentId = studentTokens[0];
        String studentFirstName = studentTokens[1];
        String studentLastName = studentTokens[2];
        String studentCohort = studentTokens[3];
        Student studentFromFile = new Student(studentId);
        studentFromFile.setFirstName(studentFirstName);
        studentFromFile.setLastName(studentLastName);
        studentFromFile.setCohort(studentCohort);
        
        return studentFromFile;
    }
    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException error) {
            throw new ClassRosterPersistenceException(
                "-_- Could not load roster data into memory.", error);
        }
        String currentLine;
        Student currentStudent;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
    }
    private String marshallStudent(Student aStudent) {
        String studentAsText = aStudent.getStudentId() + DELIMITER;
        studentAsText += aStudent.getFirstName() + DELIMITER;
        studentAsText += aStudent.getLastName() + DELIMITER;
        studentAsText += aStudent.getCohort();
        return studentAsText;
    }
    private void writeRoster() throws ClassRosterPersistenceException {
        PrintWriter out;
        
        //We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch(IOException error) {
            throw new ClassRosterPersistenceException(
            "Could not save student data.", error);
        }
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            studentAsText = marshallStudent(currentStudent);
            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }
    
    
}
