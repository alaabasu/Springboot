package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a University entity containing a list of students.
 * Used for marshaling/unmarshaling to XML format.
 */
@XmlRootElement(name = "University")
public class University {

    private List<Student> students;

    // Default constructor required for JAXB
    public University() {
        this.students = new ArrayList<>();
    }

    // Constructor with students list (optional)
    public University(List<Student> students) {
        this.students = students;
    }

    /**
     * Gets the list of students.
     * 
     * @return List of students
     */
    @XmlElement(name = "Student")
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of students.
     * 
     * @param students List of students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
